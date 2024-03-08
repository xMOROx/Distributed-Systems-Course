use cl_parser::Config;
use client::client::Client;
use std::{
    env,
    io::{self, Write},
};
use tui_colorizer::TuiColor;

fn main() {
    let config = Config::build(env::args());
    let client = Client::new(config.clone());

    client.read_from_server();

    let tx = client.write_to_server();

    loop {
        let mut buffer = String::new();
        print!("{}", TuiColor::Red.paint("> "));

        io::stdout().flush().unwrap();
        io::stdin().read_line(&mut buffer).unwrap();

        tx.send(buffer.trim().to_string()).unwrap();
    }
}
