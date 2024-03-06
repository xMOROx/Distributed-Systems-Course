use std::io::{self, Read, Write};
use std::net::TcpStream;
use std::sync::mpsc::{self, Receiver, Sender};

use cl_parser::Config;
use threads::ThreadPool;

const BUFFER_SIZE: usize = 1024;

pub struct Client {
    write_stream: TcpStream,
    read_stream: TcpStream,
    pool: ThreadPool,
}

impl Client {
    pub fn new(config: Config) -> Self {
        let stream = TcpStream::connect(config.build_socket()).unwrap();
        Client {
            write_stream: stream.try_clone().unwrap(),
            read_stream: stream.try_clone().unwrap(),
            pool: ThreadPool::build(2),
        }
    }

    pub fn read_from_server(&self) {
        let mut buffer = [0; BUFFER_SIZE];
        let mut stream = self.read_stream.try_clone().unwrap();
        self.pool.execute(move || loop {
            match stream.read(&mut buffer) {
                Ok(n) => {
                    if n == 0 {
                        break;
                    }
                    let message = String::from_utf8_lossy(&buffer[..n]).to_string();
                    println!("Message from: {}", message);
                }
                Err(e) => {
                    eprintln!("Error while reading message: {}", e);
                    break;
                }
            };
        });
    }

    pub fn write_to_server(&self) -> Sender<String> {
        let mut stream = self.write_stream.try_clone().unwrap();
        let (tx, rx) = mpsc::channel::<String>();

        self.pool.execute(move || loop {
            let message = rx.recv().unwrap();
            if let Err(e) = stream.write_all(message.as_bytes()) {
                eprintln!("Error while sending message: {}", e);
            }
        });

        tx
    }
}
