use std::str::FromStr;
use amqprs::channel::ExchangeType;
use common::Operations;
use common::server::{ConnectionBuilder, Server};
use rand::Rng;

const TECHNICIAN_NAME: &str = "TECHNICIAN ";

fn enter_operations(expected_size_of_queues: usize) -> Vec<String> {
    let mut names_of_queues: Vec<String> = vec!();

    while names_of_queues.len() < expected_size_of_queues {
        let mut input = String::new();
        println!("Enter the name of the operation: ");
        std::io::stdin().read_line(&mut input)
            .expect("Failed to read line");

        let input = input.trim();
        if input.is_empty() {
            println!("Please enter a valid name");
            continue;
        }

        match Operations::from_str(input) {
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

#[tokio::main]
async fn main() {
    let connection_request = ConnectionBuilder::new().build();
    let mut names_of_queues: Vec<String> = enter_operations(2);


    let mut server = Server::build(connection_request).await;
    let mut rng = rand::thread_rng();
    let technician_name = format!("{}{}", TECHNICIAN_NAME, rng.gen_range(1..1_000_000));

    server.declare_exchange(technician_name.as_str(), ExchangeType::Direct).await.expect("TODO: panic message");
    server.bind_to_queues_exchange(technician_name.as_str(), names_of_queues.clone()).await.expect("TODO: panic message");
    server.bind_consuming(names_of_queues.clone()).await.expect("TODO: panic message");

    // for queue in names_of_queues.iter() {
    //     let message = format!(r#"data": "{}{}{}{:?}"#, "Hello from ", technician_name, "to queue ", queue);
    //     println!("Sending message: {}", message);
    //     let content = String::from(
    //         message
    //     );
    //     server.publish(technician_name.as_str(), queue.as_str(), content).await.unwrap();
    //     tokio::time::sleep(tokio::time::Duration::from_secs(1)).await;
    // }
    loop {
        tokio::time::sleep(tokio::time::Duration::from_secs(1)).await;
    }
}

