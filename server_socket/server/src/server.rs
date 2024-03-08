use crate::{client::Client, ClientStreams};

use socket2::{Domain, Socket, Type};
use std::net::{SocketAddr, TcpListener, ToSocketAddrs, UdpSocket};
use std::sync::{Arc, Mutex};

use cl_parser::Config;
use threads::ThreadPool;
use tui_colorizer::TuiColor;

pub struct Server {
    tcp_listener: TcpListener,
    udp_listener: Arc<UdpSocket>,
    pool: ThreadPool,
    clients_tcp_streams: ClientStreams,
    clients_addresses: Arc<Mutex<Vec<String>>>,
}

impl Server {
    pub fn new(config: Config) -> Self {
        let address = config
            .build_socket()
            .to_socket_addrs()
            .unwrap()
            .next()
            .unwrap();

        println!(
            "Creating server on address {} and port {}",
            TuiColor::Green.bold_paint(config.ip_address.as_str()),
            TuiColor::Green.bold_paint(config.port.to_string().as_str())
        );

        Server {
            tcp_listener: Self::init_tcp_listener(address),
            udp_listener: Arc::new(Self::init_udp_listener(address)),
            pool: ThreadPool::build(config.number_of_threads),
            clients_tcp_streams: Arc::new(Mutex::new(Vec::new())),
            clients_addresses: Arc::new(Mutex::new(Vec::new())),
        }
    }

    pub fn listen(&mut self) {
        let mut id: usize = 0;
        let udp_listener = Arc::clone(&self.udp_listener);
        let clients_addresses = Arc::clone(&self.clients_addresses);

        self.pool.execute(move || loop {
            let mut buffer = [0; 1024];
            match udp_listener.recv_from(&mut buffer) {
                Ok((n, addr)) => {
                    let message = String::from_utf8_lossy(&buffer[..n]).to_string();
                    println!(
                        "UDP >>> Received message from: {} with content: {}",
                        TuiColor::Green.bold_paint(addr.to_string().as_str()),
                        TuiColor::Green.bold_paint(message.as_str())
                    );

                    for client in clients_addresses.lock().unwrap().iter() {
                        if client != &addr.to_string() {
                            udp_listener.send_to(&buffer[..n], client).unwrap();
                        }
                    }
                }
                Err(e) => {
                    eprintln!("Error while receiving message from UDP socket: {}", e);
                }
            }
        });

        for stream in self.tcp_listener.incoming() {
            match stream {
                Ok(s) => {
                    println!(
                        "Client with address: {} connected",
                        TuiColor::Green.bold_paint(s.peer_addr().unwrap().to_string().as_str())
                    );
                    let client_address = s.peer_addr().unwrap().to_string().clone();

                    let mut client = Client::new(s, id);
                    let clients_tcp_streams: ClientStreams = Arc::clone(&self.clients_tcp_streams);
                    let client_streams = Arc::new(Mutex::new(client.clone()));

                    self.clients_addresses.lock().unwrap().push(client_address);

                    self.pool.execute(move || {
                        clients_tcp_streams
                            .lock()
                            .unwrap()
                            .push(Arc::clone(&client_streams));
                        client.handle_tcp(clients_tcp_streams);
                    });

                    id += 1;
                }
                Err(_) => {
                    eprintln!("Error while parsing incoming stream");
                }
            }
        }
    }

    fn init_tcp_listener(address: SocketAddr) -> TcpListener {
        let tcp_listener = Socket::new(Domain::ipv4(), Type::stream(), None).unwrap();
        tcp_listener.set_reuse_port(true).unwrap();
        tcp_listener.set_reuse_address(true).unwrap();
        tcp_listener.bind(&address.into()).unwrap();
        tcp_listener.listen(1024).unwrap();

        tcp_listener.into()
    }

    fn init_udp_listener(address: SocketAddr) -> UdpSocket {
        let udp_listener = Socket::new(Domain::ipv4(), Type::dgram(), None).unwrap();
        udp_listener.set_reuse_port(true).unwrap();
        udp_listener.set_reuse_address(true).unwrap();
        udp_listener.set_broadcast(true).unwrap();
        udp_listener.bind(&address.into()).unwrap();

        udp_listener.into()
    }
}
