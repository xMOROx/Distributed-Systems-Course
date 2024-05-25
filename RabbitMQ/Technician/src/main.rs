use std::io::Write;
use std::str::FromStr;
use amqprs::channel::ExchangeType;
use common::Operations;
use common::server::{ConnectionBuilder, Server};
use rand::Rng;

struct Init {
    server: Server,
    technician_name: String,
    names_of_queues: Vec<String>,
}

const TECHNICIAN_NAME: &str = "TECHNICIAN ";
const INFO_EXCHANGE: &str = "info";
const MAX_IDS: usize = 1_000_000;

fn enter_operations(expected_size_of_queues: usize) -> Vec<String> {
    let mut names_of_queues: Vec<String> = vec!();

    while names_of_queues.len() < expected_size_of_queues {
        let mut input = String::new();
        println!("Enter the name of the operation: ");

        std::io::stdin().read_line(&mut input)
            .expect("Failed to read line");

        let input = input.trim();
        let input = input.split(" ").collect::<String>();
        if input.is_empty() {
            println!("Please enter a valid name");
            continue;
        }

        if names_of_queues.contains(&input) {
            println!("The operation name already exists");
            continue;
        }

        let input = input.split(" ").collect::<Vec<&str>>();


        if input.len() != 1 {
            println!("Only one operation name is allowed");
            continue;
        }


        match Operations::from_str(input[0]) {
            Ok(operation) => {
                names_of_queues.push(operation.into());
            }
            Err(_) => {
                println!("Please enter a valid operation name");
            }
        }
    }

    names_of_queues
}


async fn init() -> Init {
    let connection_request = ConnectionBuilder::new().build();
    let names_of_queues = enter_operations(2);

    let mut server = Server::build(connection_request).await;
    let mut rng = rand::thread_rng();
    let technician_name = format!("{}{}", TECHNICIAN_NAME, rng.gen_range(1..MAX_IDS));
    std::io::stdout().flush().unwrap();

    println!("Technician name: {}", technician_name);
    println!("Available operations: {:?}", names_of_queues);
    println!("Waiting for requests...\n");

    server.declare_exchange(technician_name.as_str(), ExchangeType::Direct)
        .await.expect("Failed to declare exchange");

    server.declare_exchange(INFO_EXCHANGE, ExchangeType::Fanout)
        .await.expect("Failed to declare exchange");

    let queue = server.create_temporary_queue()
        .await.expect("Failed to declare queue");

    server.bind_queue(queue.as_str(), INFO_EXCHANGE, "info")
        .await.expect("Failed to bind queue to exchange");

    server.bind_consume(queue.as_str())
        .await;

    server.bind_to_queues_exchange(technician_name.as_str(), vec![names_of_queues[0].clone(), names_of_queues[1].clone(), "log".to_string()])
        .await.expect("Failed to bind to exchange");

    server.bind_consuming_with_reply(names_of_queues.clone(), true)
        .await.expect("Failed to bind consuming");


    Init {
        server,
        technician_name,
        names_of_queues,
    }
}

#[tokio::main]
async fn main() {
    let Init { server: _sever, technician_name: _technician_name, names_of_queues: _names } = init().await;

    loop {
        tokio::time::sleep(tokio::time::Duration::from_secs(1)).await;
    }
}

