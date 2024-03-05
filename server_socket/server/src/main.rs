use std::env;
use cl_parser::Config;
use server::server::Server;

fn main() {
    let config = Config::build(env::args());
    let mut server:Server = Server::new(config);
    
    server.listen();

}


