use crate::ClientStreams;
use std::error::Error;
use std::io::{Read, Write};
use std::net::TcpStream;
use tui_colorizer::TuiColor;

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

    pub fn clone(&self) -> Self {
        Client {
            stream: self.stream.try_clone().unwrap(),
            id: self.id,
        }
    }

    pub fn handle_tcp(&mut self, client_streams: ClientStreams) {
        match self.handle_tcp_without_error_handling(client_streams) {
            Ok(_) => {
                println!("Client<{}> disconnected", self.id);
            }
            Err(_) => {
                eprintln!("Error while handling client<{}>", self.id);
            }
        }
    }

    pub fn formated_received_message(message: &str, id: usize, protocol: Option<&str>) -> () {
        let protocol = match protocol {
            Some(p) => p,
            None => "TCP",
        };
        println!(
            "{}{}{}{}",
            TuiColor::Purple.paint("=-=-=-=-=-=-==>> "),
            TuiColor::Yellow.bold_paint(format!("[{}]", protocol).as_str()),
            TuiColor::Blue.bold_paint(format!("Client<{}>", id).as_str()),
            TuiColor::Purple.paint(" <<==--=-=-=-=-=-")
        );
        println!("{}", message);
        println!(
            "{}{}{}{}",
            TuiColor::Purple.paint("=-=-=-=-=-=-==>> "),
            TuiColor::Yellow.bold_paint(format!("[{}]", protocol).as_str()),
            TuiColor::Blue.bold_paint(format!("Client<{}>", id).as_str()),
            TuiColor::Purple.paint(" <<==--=-=-=-=-=-")
        );
        println!("");
    }

    fn handle_tcp_without_error_handling(
        &mut self,
        client_streams: ClientStreams,
    ) -> Result<(), Box<dyn Error>> {
        loop {
            match Client::receive_tcp_message_from_client(&mut self.stream) {
                Ok(message) => {
                    let payload = Client::compose_payload(&message, self.id);

                    Self::formated_received_message(&message, self.id, None);
                    Self::resend_message_to_client(&client_streams, &payload, self.id)?;
                }
                Err(_) => {
                    eprintln!("Error while reading from stream");
                    break;
                }
            }
        }

        Ok(())
    }

    fn resend_message_to_client(
        client_streams: &ClientStreams,
        message: &str,
        id: usize,
    ) -> Result<(), Box<dyn Error>> {
        client_streams
            .lock()
            .unwrap()
            .iter()
            .filter(|client| client.lock().unwrap().id != id)
            .for_each(|client| {
                let mut client = client.lock().unwrap();
                Client::send_tcp_formated_message_to_client(&mut client, message).unwrap();
            });

        Ok(())
    }

    fn send_tcp_formated_message_to_client(
        client: &mut Client,
        message: &str,
    ) -> Result<(), Box<dyn Error>> {
        client.stream.write_all(message.as_bytes())?;
        println!(
            "{}{}{}",
            TuiColor::Green.paint("==============| "),
            TuiColor::Cyan.bold_paint(format!("client<{}>", client.id).as_str()),
            TuiColor::Green.paint(" |==============")
        );
        println!("{}", message.trim());
        println!(
            "{}{}{}",
            TuiColor::Green.paint("==============| "),
            TuiColor::Cyan.bold_paint(format!("client<{}>", client.id).as_str()),
            TuiColor::Green.paint(" |==============")
        );
        println!("");

        Ok(())
    }

    fn receive_tcp_message_from_client(mut client: &TcpStream) -> Result<String, Box<dyn Error>> {
        let mut buffer = [0; SIZE_OF_BUFFER];
        client.read(&mut buffer)?;
        let message = String::from_utf8_lossy(&buffer).to_string();
        Ok(message)
    }

    fn compose_payload(message: &str, id: usize) -> String {
        format!("<Client:{}>: {}", id, message)
    }
}
