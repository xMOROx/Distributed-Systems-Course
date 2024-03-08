use std::io::{self, Read, Write};
use std::net::{SocketAddr, TcpStream, ToSocketAddrs, UdpSocket};
use std::sync::mpsc::{self, Sender};

use crate::ASCII_ART;
use cl_parser::Config;
use socket2::{Domain, Socket, Type};
use threads::ThreadPool;
use tui_colorizer::TuiColor;

const BUFFER_SIZE: usize = 1024;

pub struct Client {
    write_stream: TcpStream,
    read_stream: TcpStream,
    udp_listener: UdpSocket,
    pool: ThreadPool,
}

impl Client {
    pub fn new(config: Config) -> Self {
        let stream = TcpStream::connect(config.build_socket()).unwrap();

        let udp_server_address = config
            .build_udp_socket()
            .to_socket_addrs()
            .unwrap()
            .next()
            .unwrap();

        let udp_address =
            SocketAddr::new(udp_server_address.ip(), stream.local_addr().unwrap().port());

        Client {
            write_stream: stream.try_clone().unwrap(),
            read_stream: stream.try_clone().unwrap(),
            udp_listener: Self::init_udp_listener(udp_address, udp_server_address),
            pool: ThreadPool::build(3),
        }
    }

    pub fn read_from_server(&self) {
        self.init_udp_reading_from_server();
        self.init_tcp_reading_from_server();
    }

    pub fn write_to_server(&self) -> Sender<String> {
        let mut stream = self.write_stream.try_clone().unwrap();
        let (tx, rx) = mpsc::channel::<String>();
        let udp_listener = self.udp_listener.try_clone().unwrap();

        self.pool.execute(move || loop {
            let message = rx.recv().unwrap();

            if message.starts_with("U") {
                if let Err(e) = udp_listener.send(ASCII_ART.as_bytes()) {
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

    pub fn formated_received_message(message: &str, protocol: Option<&str>) -> () {
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
        println!(
            "{}{}{}",
            TuiColor::Purple.paint("=-=-=-=-=-=-==>> "),
            TuiColor::Yellow.bold_paint(format!("[{}]", protocol).as_str()),
            TuiColor::Purple.paint(" <<==--=-=-=-=-=-")
        );

        print!("{}", TuiColor::Red.paint("> "));
        io::stdout().flush().unwrap();
    }

    fn init_tcp_reading_from_server(&self) {
        let mut buffer = [0; BUFFER_SIZE];
        let mut stream = self.read_stream.try_clone().unwrap();

        self.pool.execute(move || loop {
            match stream.read(&mut buffer) {
                Ok(n) => {
                    if n == 0 {
                        break;
                    }
                    let message = String::from_utf8_lossy(&buffer[..n]).to_string();
                    if !Client::check_if_message_contains_only_zeros(&message) {
                        Client::formated_received_message(&message, None);

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
    }

    fn init_udp_reading_from_server(&self) {
        let mut buffer = [0; BUFFER_SIZE];
        let udp_listener = self.udp_listener.try_clone().unwrap();

        self.pool.execute(move || loop {
            match udp_listener.recv_from(&mut buffer) {
                Ok((n, _)) => {
                    let message = String::from_utf8_lossy(&buffer[..n]).to_string();
                    Client::formated_received_message(&message, Some("UDP"));
                }
                Err(e) => {
                    eprintln!("Error while receiving message from UDP socket: {}", e);
                }
            }
        });
    }

    fn check_if_message_contains_only_zeros(message: &str) -> bool {
        message.as_bytes().iter().all(|&x| x == 0)
    }

    fn init_udp_listener(address: SocketAddr, server_address: SocketAddr) -> UdpSocket {
        let udp_listener = Socket::new(Domain::ipv4(), Type::dgram(), None).unwrap();

        udp_listener.set_reuse_port(true).unwrap();
        udp_listener.set_reuse_address(true).unwrap();
        udp_listener.set_broadcast(true).unwrap();
        udp_listener.bind(&address.into()).unwrap();
        udp_listener.connect(&server_address.into()).unwrap();

        udp_listener.into()
    }
}
