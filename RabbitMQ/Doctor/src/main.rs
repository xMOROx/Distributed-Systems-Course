use amqprs::callbacks::DefaultChannelCallback;
use amqprs::channel::BasicQosArguments;
use common::server::{ConnectionBuilder, ConnectionRequest, Server};


#[tokio::main]
async fn main() {
    let connection_request = ConnectionBuilder::new().build();

    let connection = Server::connect(connection_request).await;
    let channel = connection.open_channel(None).await.unwrap();
    channel
        .register_callback(DefaultChannelCallback)
        .await
        .unwrap();
    let args = BasicQosArguments {
        prefetch_size: 0,
        prefetch_count: 1,
        global: false,
    };
    channel.basic_qos(args).unwrap()
}
