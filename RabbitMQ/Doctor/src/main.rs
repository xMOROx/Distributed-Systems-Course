use amqprs::channel::ExchangeType;
use common::Operations;
use common::server::{ConnectionBuilder, Server};
use std::str::FromStr;
use rand::Rng;
const DOCTOR_NAME: &str = "DOCTOR ";

#[tokio::main]
async fn main() {
    let connection_request = ConnectionBuilder::new().build();

    let mut server = Server::build(connection_request).await;
    let names_of_queues:Vec<Operations> = vec![Operations::Hip, Operations::Knee, Operations::Elbow];
    let mut rng = rand::thread_rng();
    let doctor_name = format!("{}{}", DOCTOR_NAME, rng.gen_range(1..1_000_000));

    server.declare_exchange(doctor_name.as_str(), ExchangeType::Direct).await.expect("TODO: panic message");
    let mut names_of_queues:Vec<String> = names_of_queues.iter().map(|&operation| operation.into()).collect();
    names_of_queues.push(doctor_name.clone());
    server.bind_to_queues_exchange(doctor_name.as_str(), names_of_queues).await.expect("TODO: panic message");
    server.bind_consuming(vec![doctor_name.clone()]).await.expect("TODO: panic message");

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

        let operation = match  Operations::from_str(input[0]) {
            Ok(operation) => operation,
            Err(_) => {
                println!("Please enter a valid operation name");
                continue;
            }
        };

        let surname = input[1].trim();

        let message = format!(r"job:{}, {}", <Operations as Into<String>>::into(operation), surname);

        println!("Sending message: {}", message);
        let operation:String = operation.into();
        server.publish_with_reply(doctor_name.as_str(), operation.as_str(), doctor_name.as_str(), message).await.expect("TODO: panic message");

        tokio::time::sleep(tokio::time::Duration::from_secs(1)).await;
    }
}
