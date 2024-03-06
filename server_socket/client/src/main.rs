use cl_parser::Config;
use client::client::Client;
use core::time;
use std::io::Write;
use std::{
    env,
    io::{self, Read},
    net::TcpStream,
    sync::{
        mpsc::{self, Sender},
        Arc, Mutex,
    },
    thread,
};

fn main() {
    let config = Config::build(env::args());
    let client = Client::new(config);

    client.read_from_server();

    let tx = client.write_to_server();

    loop {
        let mut buffer = String::new();
        io::stdin().read_line(&mut buffer).unwrap();
        tx.send(buffer).unwrap();
    }
}
