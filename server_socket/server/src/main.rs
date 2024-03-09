use cl_parser::Config;
use server::server::Server;
use std::env;

fn main() {
    let config = Config::build(env::args());
    let mut server: Server = Server::build(config);

    server.listen();
}
