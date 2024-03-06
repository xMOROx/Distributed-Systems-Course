use std::net::{TcpListener, TcpStream};
use std::sync::mpsc::{self, Sender};
use std::sync::{Arc, Mutex};
use std::thread;

use cl_parser::Config;
use threads::ThreadPool;

use crate::client::Client;

pub struct Server {
    pub listener: TcpListener,
    pub pool: ThreadPool,
    pub clients_count: usize,
    pub clients_sender: Arc<Mutex<Vec<Arc<Mutex<TcpStream>>>>>,
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
                    let client_stream = Arc::new(Mutex::new(client.stream.try_clone().unwrap()));

                    self.pool.execute(move || {
                        clients_sender
                            .lock()
                            .unwrap()
                            .push(Arc::clone(&client_stream));
                        client.handle_client(clients_sender);
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
