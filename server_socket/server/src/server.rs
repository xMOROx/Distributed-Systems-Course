use std::io::{self, Read, Write};
use std::net::{Ipv4Addr, Shutdown, SocketAddr, SocketAddrV4, TcpListener, TcpStream};
use std::sync::mpsc::{self, Receiver, Sender};
use std::sync::{Arc, Mutex};

use cl_parser::Config;
use threads::ThreadPool;

use crate::client::Client;

pub struct Server {
    pub listener: TcpListener,
    pub pool: ThreadPool,
    pub clients_count: usize,
    pub clients_sender: Arc<Mutex<Vec<Sender<String>>>>,
}

impl Server {
    pub fn new(config: Config) -> Self {
        let listener = TcpListener::bind(config.build_socket()).unwrap();

        println!(
            "Creating server on address {} and port {}",
            config.ip_address, config.port
        );

        Server {
            listener,
            pool: ThreadPool::build(config.number_of_threads),
            clients_count: 0,
            clients_sender: Arc::new(Mutex::new(Vec::new())),
        }
    }

    pub fn listen(&mut self) {
        let mut id: usize = 0;

        for stream in self.listener.incoming() {
            match stream {
                Ok(s) => {
                    println!("{:?}", s.peer_addr());
                    let mut client = Client::new(s, id);
                    self.clients_count += 1;
                    let clients_sender = Arc::clone(&self.clients_sender);

                    self.pool.execute(move || {
                        let (tx, rx) = mpsc::channel::<String>();
                        let clone_senders = Arc::clone(&clients_sender);
                        clone_senders.lock().unwrap().push(tx.clone());
                        client.handle_client(rx, clone_senders).unwrap();
                    });

                    id += 1;
                }
                Err(_) => {
                    eprintln!("Error while parsing incoming stream");
                }
            }
        }
    }
}
