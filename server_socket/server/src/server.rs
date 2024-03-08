use crate::{client::Client, ClientAddresses, ClientData, ClientStreams};

use socket2::{Domain, Socket, Type};
use std::net::{SocketAddr, TcpListener, TcpStream, ToSocketAddrs, UdpSocket};
use std::sync::{Arc, Mutex};

use cl_parser::Config;
use threads::ThreadPool;
use tui_colorizer::TuiColor;

pub struct Server {
    pool: ThreadPool,
    tcp_listener: TcpListener,
    udp_socket: Arc<UdpSocket>,
    clients_tcp_streams: ClientStreams,
    clients_data: ClientAddresses,
}

impl Server {
    pub fn new(config: Config) -> Self {
        let address = Self::build_socket_address(&config);
        Self::print_server_address(address.to_string().as_str());

        Server {
            pool: ThreadPool::build(config.number_of_threads),
            tcp_listener: Self::init_tcp_listener(address),
            udp_socket: Arc::new(Self::init_udp_socket(address)),
            clients_tcp_streams: Arc::new(Mutex::new(Vec::new())),
            clients_data: Arc::new(Mutex::new(Vec::new())),
        }
    }

    pub fn listen(&mut self) {
        self.run_udp_listener();
        self.run_tcp_listener();
    }

    fn build_socket_address(config: &Config) -> SocketAddr {
        config
            .build_socket()
            .to_socket_addrs()
            .unwrap()
            .next()
            .unwrap()
    }

    fn print_new_client(client_address: &str) {
        println!(
            "Client with address: {} connected",
            TuiColor::Green.bold_paint(client_address)
        );
    }

    fn print_server_address(address: &str) {
        println!(
            "Server is listening on address: {}",
            TuiColor::Green.bold_paint(address)
        );
        println!("");
    }

    fn get_client_address_from_stream(stream: &TcpStream) -> String {
        stream.peer_addr().unwrap().to_string()
    }

    fn run_udp_listener(&self) {
        let udp_socket = Arc::clone(&self.udp_socket);
        let clients_data = Arc::clone(&self.clients_data);

        self.pool.execute(move || loop {
            let mut buffer = [0; 1024];
            match udp_socket.recv_from(&mut buffer) {
                Ok((n, addr)) => {
                    let message = String::from_utf8_lossy(&buffer[..n]).to_string();
                    let id = Self::find_id_by_address(&addr.to_string(), &clients_data);

                    Client::formated_received_message(&message, id, Some("UDP"));

                    Self::send_through_to_other_udp_clients(
                        &udp_socket,
                        &buffer,
                        &clients_data,
                        &addr,
                    );
                }
                Err(e) => {
                    eprintln!("Error while receiving message from UDP socket: {}", e);
                }
            }
        });
    }

    fn find_id_by_address(address: &str, clients_data: &ClientAddresses) -> usize {
        clients_data
            .lock()
            .unwrap()
            .iter()
            .find(|client| client.address.as_str() == address)
            .unwrap()
            .id
    }

    fn send_through_to_other_udp_clients(
        udp_socket: &UdpSocket,
        buffer: &[u8],
        clients_data: &ClientAddresses,
        addr: &SocketAddr,
    ) {
        for client in clients_data.lock().unwrap().iter() {
            if client.address.as_str() != &addr.to_string() {
                udp_socket
                    .send_to(&buffer, client.address.as_str())
                    .unwrap();
            }
        }
    }

    fn run_tcp_listener(&self) {
        let mut id: usize = 0;

        for stream in self.tcp_listener.incoming() {
            match stream {
                Ok(s) => {
                    let client_address = Self::get_client_address_from_stream(&s);

                    Self::print_new_client(&client_address);
                    self.clients_data
                        .lock()
                        .unwrap()
                        .push(ClientData::new(id, client_address));

                    let mut client = Client::new(s, id);
                    let clients_tcp_streams: ClientStreams = Arc::clone(&self.clients_tcp_streams);
                    let client_streams = Arc::new(Mutex::new(client.clone()));

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

    fn init_udp_socket(address: SocketAddr) -> UdpSocket {
        let udp_socket = Socket::new(Domain::ipv4(), Type::dgram(), None).unwrap();
        udp_socket.set_reuse_port(true).unwrap();
        udp_socket.set_reuse_address(true).unwrap();
        udp_socket.set_broadcast(true).unwrap();
        udp_socket.bind(&address.into()).unwrap();

        udp_socket.into()
    }
}
