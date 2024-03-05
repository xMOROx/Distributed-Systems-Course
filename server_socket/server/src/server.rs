use std::net::{
    TcpListener,
    TcpStream,
    Ipv4Addr,
    SocketAddr,
    SocketAddrV4,
    Shutdown
};
use std::{thread, time};
use std::sync::{Arc, Mutex};
use std::marker::Sized;
use std::io::{ self, Read, Write };

use cl_parser::Config;
use threads::ThreadPool;

use crate::client::Client;

pub struct Server {
    pub listener: Arc<TcpListener>,
    pub clients: Arc<Mutex<Vec<Arc<Mutex<Client>>>>>,
    pub pool: ThreadPool,
}

impl Server {
    pub fn new(config: Config) -> Self {
        let listener = TcpListener::bind(config.build_socket()).unwrap();

        println!("Creating server on address {} and port {}", config.ip_address, config.port);

        Server {
            listener: Arc::new(listener),
            clients: Arc::new(Mutex::new(vec![])),
            pool: ThreadPool::build(config.number_of_threads),
        }
    }
    
    pub fn listen(&mut self) {
        let temp_clients = Arc::clone(&self.clients);
        let mut id:usize = 0;
        for stream in self.listener.incoming() {
            match stream {
                Ok(s) =>  {
                    println!("{:?}",s.peer_addr());

                    let mut thread_clients = temp_clients.lock().unwrap();
                    let client = Client::new(s, id);
                    let client = Arc::new(Mutex::new(client));

                    thread_clients.push(client.clone());

                    let pass_client:Vec<_> = thread_clients
                        .iter()
                        .map(|c| Arc::clone(&c))
                        .collect();

                    self.pool.execute(move || {
                        loop {
                            let sender = pass_client.get(id).unwrap().lock().unwrap();
                            println!("{sender:#?}");
                            thread::sleep(std::time::Duration::from_millis(300));
                        }
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
