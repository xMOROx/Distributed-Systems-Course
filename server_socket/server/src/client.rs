use std::io::{Read, Write};
use std::net::TcpStream;
use std::sync::Mutex;
use std::sync::{
    mpsc::{Receiver, Sender},
    Arc,
};

const SIZE_OF_BUFFER: usize = 1024;

#[derive(Debug)]
pub struct Client {
    pub stream: TcpStream,
    pub id: usize,
}

impl Client {
    pub fn new(stream: TcpStream, id: usize) -> Self {
        Client { stream, id }
    }

    pub fn handle_client(&mut self, client_sender: Arc<Mutex<Vec<Arc<Mutex<TcpStream>>>>>) {
        loop {
            let mut buffer = [0; SIZE_OF_BUFFER];
            let result = self.stream.read(&mut buffer);
            match result {
                Ok(_) => {
                    let message = String::from_utf8_lossy(&buffer).to_string();
                    let header = format!("<Client:{}>: ", self.id);
                    let payload = format!("{}{}", header, message);
                    println!("Message from client<{}>: {}", self.id, message);

                    client_sender
                        .lock()
                        .unwrap()
                        .iter()
                        .filter(|client| {
                            client.lock().unwrap().peer_addr().unwrap()
                                != self.stream.peer_addr().unwrap()
                        })
                        .for_each(|client| {
                            client
                                .lock()
                                .unwrap()
                                .write_all(payload.as_bytes())
                                .unwrap();
                        });
                }
                Err(_) => {
                    eprintln!("Error while reading from stream");
                    break;
                }
            }
        }
    }
}
