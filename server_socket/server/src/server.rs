use crate::{client::Client, ClientStreams};

use std::net::TcpListener;
use std::sync::{Arc, Mutex};

use cl_parser::Config;
use threads::ThreadPool;
use tui_colorizer::TuiColor;

pub struct Server {
    pub listener: TcpListener,
    pub pool: ThreadPool,
    pub clients_streams: ClientStreams,
}

impl Server {
    pub fn new(config: Config) -> Self {
        let listener = TcpListener::bind(config.build_socket()).unwrap();

        println!(
            "Creating server on address {} and port {}",
            TuiColor::Green.bold_paint(config.ip_address.as_str()),
            TuiColor::Green.bold_paint(config.port.to_string().as_str())
        );

        Server {
            listener,
            pool: ThreadPool::build(config.number_of_threads),
            clients_streams: Arc::new(Mutex::new(Vec::new())),
        }
    }

    pub fn listen(&mut self) {
        let mut id: usize = 0;

        for stream in self.listener.incoming() {
            match stream {
                Ok(s) => {
                    println!("{:?}", s.peer_addr());
                    let mut client = Client::new(s, id);
                    let clients_streams: ClientStreams = Arc::clone(&self.clients_streams);
                    let client_stream = Arc::new(Mutex::new(client.clone()));

                    self.pool.execute(move || {
                        clients_streams
                            .lock()
                            .unwrap()
                            .push(Arc::clone(&client_stream));
                        client.handle_client(clients_streams);
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
