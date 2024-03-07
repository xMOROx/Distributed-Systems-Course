use cl_parser::Config;
use client::client::Client;
use std::{
    env,
    io::{self, Write},
};

fn main() {
    let config = Config::build(env::args());
    let client = Client::new(config);

    client.read_from_server();

    let tx = client.write_to_server();

    loop {
        let mut buffer = String::new();
        print!("> ");
        io::stdout().flush().unwrap();

        io::stdin().read_line(&mut buffer).unwrap();
        tx.send(buffer.trim().to_string()).unwrap();
    }
}
