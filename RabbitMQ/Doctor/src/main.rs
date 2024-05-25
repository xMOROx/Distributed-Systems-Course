use amqprs::channel::ExchangeType;
use common::Operations;
use common::server::{ConnectionBuilder, Server};
use std::str::FromStr;
use rand::Rng;

const DOCTOR_NAME: &str = "DOCTOR ";
const SLEEP_TIME: u64 = 1;
const MAX_IDS: u64 = 1_000_000;
const INFO_EXCHANGE: &str = "info";

struct Init {
    server: Server,
    doctor_name: String,
    names_of_queues: Vec<String>,
}

fn compose_message(operation: Operations, surname: &str) -> String {
    format!(r"job:{}, {}", <Operations as Into<String>>::into(operation), surname)
}

async fn program_loop(server: &mut Server, doctor_name: String) {
    loop {
        let mut input = String::new();
        println!("Enter the name of the operation and surname: ");

        std::io::stdin().read_line(&mut input)
            .expect("Failed to read line");

        let input = input.split(" ").collect::<Vec<&str>>();

        if input.len() < 2 {
            println!("Please enter a valid name");
            continue;
        }

        let operation = match Operations::from_str(input[0]) {
            Ok(operation) => operation,
            Err(_) => {
                println!("Please enter a valid operation name");
                continue;
            }
        };

        let surname = input[1].trim();

        let message = compose_message(operation, surname);

        println!("Sending message: {}", message);
        let operation: String = operation.into();
        server.publish_with_reply(doctor_name.as_str(), operation.as_str(), doctor_name.as_str(), message)
            .await.expect("Publish failed");

        tokio::time::sleep(tokio::time::Duration::from_secs(SLEEP_TIME)).await;
    }
}

async fn init() -> Init {
    let connection_request = ConnectionBuilder::new().build();
    let mut rng = rand::thread_rng();

    let mut server = Server::build(connection_request).await;
    let names_of_queues: Vec<Operations> = vec![Operations::Hip, Operations::Knee, Operations::Elbow];
    let doctor_name = format!("{}{}", DOCTOR_NAME, rng.gen_range(1..MAX_IDS));

    server.declare_exchange(doctor_name.as_str(), ExchangeType::Direct)
        .await.expect("Declare exchange failed");

    let mut names_of_queues: Vec<String> = names_of_queues.iter().map(|&operation| operation.into()).collect();

    names_of_queues.push(doctor_name.clone());
    names_of_queues.push("log".to_string());

    server.bind_to_queues_exchange(doctor_name.as_str(), names_of_queues.clone())
        .await.expect("Binding queues to exchange failed");

    server.bind_consuming(vec![doctor_name.clone()], true)
        .await.expect("Binding consuming failed");

    server.declare_exchange(INFO_EXCHANGE, ExchangeType::Fanout)
        .await.expect("Failed to declare exchange");

    let queue = server.create_temporary_queue()
        .await.expect("Failed to declare queue");

    server.bind_queue(queue.as_str(), INFO_EXCHANGE, "info")
        .await.expect("Failed to bind queue to exchange");

    server.bind_consume(queue.as_str())
        .await;


    Init {
        server,
        doctor_name,
        names_of_queues,
    }
}

#[tokio::main]
async fn main() {
    let Init { mut server, doctor_name, names_of_queues: _names } = init().await;

    program_loop(&mut server, doctor_name).await;
}
