use amqprs::channel::ExchangeType;
use common::Operations;
use common::server::{ConnectionBuilder, Server};
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
    server.bind_to_queues_exchange(doctor_name.as_str(), names_of_queues.iter().map(|&v| v.into()).collect()).await.expect("TODO: panic message");
    server.bind_consuming(names_of_queues.iter().map(|&v| v.into()).collect()).await.expect("TODO: panic message");


}
