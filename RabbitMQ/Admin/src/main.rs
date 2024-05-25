use amqprs::channel::ExchangeType;
use common::server::{ConnectionBuilder, Server};

const ADMIN: &str = "ADMIN";
const INFO_EXCHANGE: &str = "info";
const SLEEP_TIME: u64 = 1;

struct Init {
    server: Server,
    admin_name: String,
    names_of_queues: Vec<String>,
}

async fn init() -> Init {
    let connection_request = ConnectionBuilder::new().build();

    let mut server = Server::build(connection_request).await;
    let names_of_queues: Vec<String> = vec!["log".to_string()];


    server.declare_exchange(ADMIN, ExchangeType::Direct)
        .await.expect("Declare exchange failed");

    server.bind_to_queues_exchange(ADMIN, names_of_queues.clone())
        .await.expect("Binding queues to exchange failed");

    server.declare_exchange(INFO_EXCHANGE, ExchangeType::Fanout)
        .await.expect("Declare exchange failed");

    server.bind_consuming(vec!["log".to_string()], false)
        .await.expect("Binding consuming failed");

    server.disable_qos().await.expect("Disable QoS failed");


    Init {
        server,
        admin_name: INFO_EXCHANGE.to_string(),
        names_of_queues,
    }
}

async fn program_loop(server: &mut Server) {
    loop {
        let mut input = String::new();
        println!("Enter the message: ");

        std::io::stdin().read_line(&mut input)
            .expect("Failed to read line");

        let input = input.trim();
        let input = format!("{} {}", "info: ", input);

        println!("Sending message: {}", input);
        server.publish(INFO_EXCHANGE, "info", input.to_string())
            .await.expect("Publish failed");

        tokio::time::sleep(tokio::time::Duration::from_secs(SLEEP_TIME)).await;
    }
}

#[tokio::main]
async fn main() {
    let Init { mut server, admin_name: _admin_name, names_of_queues: _names } = init().await;

    program_loop(&mut server).await;
}
