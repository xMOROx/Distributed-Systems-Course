use std::error::Error;
use std::io::{self, Read, Write};
use std::net::{Ipv4Addr, SocketAddr, SocketAddrV4, TcpStream, ToSocketAddrs, UdpSocket};
use std::sync::mpsc::{self, Sender};

use crate::ASCII_ART;
use cl_parser::Config;
use socket2::{Domain, Protocol, Socket, Type};
use threads::ThreadPool;
use tui_colorizer::TuiColor;

const BUFFER_SIZE: usize = 1024;
const MULTICAST_ADDR: Ipv4Addr = Ipv4Addr::new(224, 0, 0, 69);
const MULTICAST_PORT: u16 = 42069;

struct TcpStreamWrapper {
    write: TcpStream,
    read: TcpStream,
}

struct MultiCastSocket {
    listener: UdpSocket,
    sender: UdpSocket,
}

pub struct Client {
    stream: TcpStreamWrapper,
    udp_socket: UdpSocket,
    multicast_socket: MultiCastSocket,
    pool: ThreadPool,
}

impl TcpStreamWrapper {
    pub fn new(config: &Config) -> Self {
        let stream = TcpStream::connect(config.build_socket()).unwrap();
        TcpStreamWrapper {
            write: stream.try_clone().unwrap(),
            read: stream.try_clone().unwrap(),
        }
    }

    pub fn local_addr(&self) -> Result<SocketAddr, Box<dyn Error>> {
        Ok(self.write.local_addr()?)
    }

    pub fn read(&self) -> Result<TcpStream, Box<dyn Error>> {
        Ok(self.read.try_clone()?)
    }

    pub fn write(&self) -> Result<TcpStream, Box<dyn Error>> {
        Ok(self.write.try_clone()?)
    }
}

impl MultiCastSocket {
    pub fn listener(&self) -> Result<UdpSocket, Box<dyn Error>> {
        Ok(self.listener.try_clone()?)
    }

    pub fn sender(&self) -> Result<UdpSocket, Box<dyn Error>> {
        Ok(self.sender.try_clone()?)
    }
}

impl Client {
    pub fn new(config: Config) -> Self {
        let stream = TcpStreamWrapper::new(&config);

        let udp_server_address = config
            .build_udp_socket()
            .to_socket_addrs()
            .unwrap()
            .next()
            .unwrap();

        let udp_address =
            SocketAddr::new(udp_server_address.ip(), stream.local_addr().unwrap().port());
        let multicast_address = SocketAddrV4::new(MULTICAST_ADDR, MULTICAST_PORT);

        Client {
            stream,
            udp_socket: Self::init_udp_socket(udp_address, udp_server_address).unwrap(),
            multicast_socket: Self::init_multicast_socket(multicast_address).unwrap(),
            pool: ThreadPool::build(4),
        }
    }

    pub fn read_from_server(&self) {
        self.init_udp_reading_from_server()
            .expect("Error while initializing reading from server as UDP");
        self.init_tcp_reading_from_server()
            .expect("Error while initializing reading from server as TCP");
        self.init_multicast_reading_from_server()
            .expect("Error while initializing reading from server as Multicast");
    }

    pub fn write_to_server(&self) -> Sender<String> {
        let mut stream = self
            .stream
            .write()
            .expect("Error while getting write stream");

        let (tx, rx) = mpsc::channel::<String>();

        let udp_socket = self
            .udp_socket
            .try_clone()
            .expect("Error while cloning UDP socket");

        let multicast_sender = self
            .multicast_socket
            .sender()
            .expect("Error while getting multicast sender");

        let multicast_address = SocketAddr::new(MULTICAST_ADDR.into(), MULTICAST_PORT);

        self.pool.execute(move || loop {
            let message = rx.recv().expect("Error while receiving message");

            if message.eq("U") {
                if let Err(e) = udp_socket.send(ASCII_ART.as_bytes()) {
                    eprintln!("Error while sending message: {}", e);
                }
            } else if message.eq("M") {
                if let Err(e) = multicast_sender.send_to(ASCII_ART.as_bytes(), multicast_address) {
                    eprintln!("Error while sending message: {}", e);
                }
            } else {
                if let Err(e) = stream.write_all(message.as_bytes()) {
                    eprintln!("Error while sending message: {}", e);
                }
            }
        });

        tx
    }

    pub fn formated_received_message(
        message: &str,
        protocol: Option<&str>,
    ) -> Result<(), Box<dyn Error>> {
        let protocol = match protocol {
            Some(p) => p,
            None => "TCP",
        };
        println!(
            "{}{}{}",
            TuiColor::Purple.paint("=-=-=-=-=-=-==>> "),
            TuiColor::Yellow.bold_paint(format!("[{}]", protocol).as_str()),
            TuiColor::Purple.paint(" <<==--=-=-=-=-=-")
        );
        println!("{}", message);

        print!("{}", TuiColor::Red.paint("> "));
        io::stdout().flush()?;
        println!(
            "{}{}{}",
            TuiColor::Purple.paint("=-=-=-=-=-=-==>> "),
            TuiColor::Yellow.bold_paint(format!("[{}]", protocol).as_str()),
            TuiColor::Purple.paint(" <<==--=-=-=-=-=-")
        );

        print!("{}", TuiColor::Red.paint("> "));
        io::stdout().flush()?;
        Ok(())
    }

    fn init_tcp_reading_from_server(&self) -> Result<(), Box<dyn Error>> {
        let mut buffer = [0; BUFFER_SIZE];
        let mut stream = self.stream.read()?;

        self.pool.execute(move || loop {
            match stream.read(&mut buffer) {
                Ok(n) => {
                    if n == 0 {
                        break;
                    }
                    let message = String::from_utf8_lossy(&buffer[..n]).to_string();
                    if !Client::check_if_message_contains_only_zeros(&message) {
                        Client::formated_received_message(&message, None)
                            .expect("Error while formating message");

                        if message.eq("exit") {
                            break;
                        }
                    }
                }
                Err(e) => {
                    eprintln!("Error while reading message: {}", e);
                    break;
                }
            };
        });

        Ok(())
    }

    fn init_udp_reading_from_server(&self) -> Result<(), Box<dyn Error>> {
        let mut buffer = [0; BUFFER_SIZE];
        let udp_socket = self.udp_socket.try_clone()?;

        self.pool.execute(move || loop {
            match udp_socket.recv_from(&mut buffer) {
                Ok((n, _)) => {
                    let message = String::from_utf8_lossy(&buffer[..n]).to_string();
                    Client::formated_received_message(&message, Some("UDP"))
                        .expect("Error while formating message as UDP");
                }
                Err(e) => {
                    eprintln!("Error while receiving message from UDP socket: {}", e);
                }
            }
        });

        Ok(())
    }

    fn init_multicast_reading_from_server(&self) -> Result<(), Box<dyn Error>> {
        let mut buffer = [0; BUFFER_SIZE];
        let multicast_socket = self.multicast_socket.listener()?;

        self.pool.execute(move || loop {
            match multicast_socket.recv_from(&mut buffer) {
                Ok((n, _)) => {
                    let message = String::from_utf8_lossy(&buffer[..n]).to_string();
                    Client::formated_received_message(&message, Some("Multicast"))
                        .expect("Error while formating message as Multicast");
                }
                Err(e) => {
                    eprintln!("Error while receiving message from Multicast socket: {}", e);
                }
            }
        });

        Ok(())
    }

    fn check_if_message_contains_only_zeros(message: &str) -> bool {
        message.as_bytes().iter().all(|&x| x == 0)
    }

    fn init_udp_socket(
        address: SocketAddr,
        server_address: SocketAddr,
    ) -> Result<UdpSocket, Box<dyn Error>> {
        let socket = Client::new_udp_socket(address)?;
        socket.connect(&server_address.into())?;

        Ok(socket.into())
    }

    fn init_udp_multicast_socket(
        multicast_address: SocketAddrV4,
    ) -> Result<UdpSocket, Box<dyn Error>> {
        let ipv4_socket_addr = SocketAddr::V4(multicast_address);
        let socket = Client::new_udp_socket(ipv4_socket_addr)?;
        socket.join_multicast_v4(&multicast_address.ip(), &Ipv4Addr::new(0, 0, 0, 0))?;

        Ok(socket.into())
    }

    fn init_multicast_socket(
        multicast_address: SocketAddrV4,
    ) -> Result<MultiCastSocket, Box<dyn Error>> {
        let listener = Client::init_udp_multicast_socket(multicast_address)?;
        let sender = Client::new_udp_socket(SocketAddr::new(Ipv4Addr::new(0, 0, 0, 0).into(), 0))?;
        sender.set_multicast_if_v4(&Ipv4Addr::new(0, 0, 0, 0))?;

        Ok(MultiCastSocket {
            listener,
            sender: sender.into(),
        })
    }

    fn new_udp_socket(bind_address: SocketAddr) -> Result<Socket, Box<dyn Error>> {
        let socket = Socket::new(Domain::ipv4(), Type::dgram(), Some(Protocol::udp()))?;
        socket.set_reuse_port(true)?;
        socket.set_reuse_address(true)?;
        socket.bind(&bind_address.into())?;

        Ok(socket)
    }
}
