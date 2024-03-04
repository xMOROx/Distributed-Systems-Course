use std::net::{TcpListener, TcpStream};
use cl_parser::Config;
use threads::ThreadPool;
use std::env;

fn main() {
    let config = Config::build(env::args());
    let server_listener = TcpListener::bind(build_socket(&config))
        .expect("Unable to listen on given port");

    println!("Launching server on address {} and port {}", config.ip_address, config.port);
    
    let pool = ThreadPool::build(config.number_of_threads);

    for stream in server_listener.incoming() {
        let stream = stream.unwrap();

        pool.execute(|| {
        });
    }
}


fn build_socket(config:&Config) -> String {
    format!("{}:{}", config.ip_address, config.port)
}
