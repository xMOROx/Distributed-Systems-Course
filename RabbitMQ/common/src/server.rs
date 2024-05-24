use amqprs::{BasicProperties, channel, Deliver};
use amqprs::channel::{BasicAckArguments, BasicConsumeArguments, BasicPublishArguments, Channel, ExchangeType, QueueBindArguments, QueueDeclareArguments};
use amqprs::connection::{Connection, OpenConnectionArguments};
use amqprs::consumer::{AsyncConsumer};
use async_trait::async_trait;

pub const RABBITMQ_PORT: u16 = 5672;

pub struct ConnectionRequest {
    pub ip: String,
    pub username: String,
    pub password: String,
}

pub struct ConnectionBuilder {
    ip: Option<String>,
    username: Option<String>,
    password: Option<String>,
}

impl ConnectionBuilder {
    pub fn new() -> ConnectionBuilder {
        ConnectionBuilder {
            ip: None,
            username: None,
            password: None,
        }
    }

    pub fn with_ip(mut self, ip: &str) -> ConnectionBuilder {
        self.ip = Some(ip.to_string());
        self
    }

    pub fn with_username(mut self, username: &str) -> ConnectionBuilder {
        self.username = Some(username.to_string());
        self
    }

    pub fn with_password(mut self, password: &str) -> ConnectionBuilder {
        self.password = Some(password.to_string());
        self
    }

    pub fn build(self) -> ConnectionRequest {
        ConnectionRequest {
            ip: self.ip.unwrap_or("localhost".to_string()),
            username: self.username.unwrap_or("guest".to_string()),
            password: self.password.unwrap_or("guest".to_string()),
        }
    }
}


pub struct AckConsumerWithReply {
    ack: bool,
}

pub struct AckConsumer {
    ack: bool,
}

impl AckConsumerWithReply {
    pub fn new() -> Self {
        Self { ack: true }
    }
}

impl AckConsumer {
    pub fn new() -> Self {
        Self { ack: true }
    }
}

#[async_trait]
impl AsyncConsumer for AckConsumerWithReply {
    async fn consume(&mut self, channel: &Channel, deliver: Deliver, basic_properties: BasicProperties, content: Vec<u8>) {
        let message: String = String::from_utf8(content).unwrap();
        let ack = BasicAckArguments::new(deliver.delivery_tag(), self.ack);
        let reply_to = basic_properties.reply_to().unwrap_or(&"".to_string()).to_owned();

        println!("Replying to: {}", reply_to);



        channel.basic_ack(ack).await.expect("Failed to ack message");
        println!("Received message: {}", message);


        let received = message.split(":").collect::<Vec<&str>>();
        let job_fields = received[1].split(",").collect::<Vec<&str>>();

        channel.basic_publish(
            BasicProperties::default()
                .with_reply_to(reply_to.clone().as_str()).finish(),
            format!("Name:{}, Operation:{} done", job_fields[0], job_fields[1]).into_bytes(),
            BasicPublishArguments::new(deliver.exchange(), &reply_to),
        ).await.expect("Failed to publish reply message");
    }
}

#[async_trait]
impl AsyncConsumer for AckConsumer {
    async fn consume(&mut self, channel: &Channel, deliver: Deliver, _basic_properties: BasicProperties, content: Vec<u8>) {
        let message: String = String::from_utf8(content).unwrap();
        let ack = BasicAckArguments::new(deliver.delivery_tag(), self.ack);

        channel.basic_ack(ack).await.expect("Failed to ack message");
        println!("Received message: {}", message);
    }
}

pub struct Server {
    pub connection: Connection,
    pub channel: channel::Channel,
    pub exchanges: Vec<String>,
}

impl Server {
    pub async fn build(request: ConnectionRequest) -> Server {
        let connection = Self::connect(request)
            .await;

        let channel = Self::open_channel(&connection)
            .await
            .expect("Failed to open channel");

        Self::set_qos(&channel)
            .await
            .expect("Failed to set QoS");

        Server {
            connection,
            channel,
            exchanges: Vec::new(),
        }
    }

    async fn connect(request: ConnectionRequest) -> Connection {
        Connection::open(&OpenConnectionArguments::new(
            request.ip.as_str(),
            RABBITMQ_PORT,
            request.username.as_str(),
            request.password.as_str(),
        ))
            .await
            .expect("Failed to connect to RabbitMQ")
    }

    async fn open_channel(connection: &Connection) -> Result<channel::Channel, amqprs::error::Error> {
        let channel = connection.open_channel(None).await;

        match channel {
            Ok(channel) => {
                channel.register_callback(amqprs::callbacks::DefaultChannelCallback).await?;
                Ok(channel)
            }
            Err(err) => Err(err),
        }
    }

    async fn set_qos(channel: &channel::Channel) -> Result<(), amqprs::error::Error> {
        let args = channel::BasicQosArguments {
            prefetch_size: 0,
            prefetch_count: 1,
            global: false,
        };

        channel.basic_qos(args).await?;
        Ok(())
    }
    pub async fn close(&mut self) -> Result<(), amqprs::error::Error> {
        todo!("Close the connection")
    }

    pub async fn declare_exchange(&mut self, exchange_name: &str, exchange_type: ExchangeType) -> Result<(), amqprs::error::Error> {
        let args = channel::ExchangeDeclareArguments::of_type(exchange_name, exchange_type);

        self.exchanges.push(exchange_name.to_string());

        self.channel.exchange_declare(args).await
    }

    pub async fn bind_to_queues_exchange(&mut self, exchange_name: &str, queue_names: Vec<String>) -> Result<(), amqprs::error::Error> {
        for queue_future_name in queue_names {
            let args = QueueDeclareArguments::new(queue_future_name.as_str());
            let queue_name = if let Some((_queue_name, _, _)) = self.channel.queue_declare(args).await? {
                _queue_name
            } else {
                Err(amqprs::error::Error::ChannelUseError(format!("{} {}", "Failed to declare queue with name ", &queue_future_name)))?
            };

            let args = QueueBindArguments::new(queue_name.as_str(), exchange_name, queue_name.as_str());

            self.channel.queue_bind(args).await?;
        }

        Ok(())
    }

    pub async fn bind_consuming_with_reply(&mut self, queue_names: Vec<String>) -> Result<(), amqprs::error::Error> {
        for queue_name in queue_names {
            let random_tag = format!("consumer_tag_{}", rand::random::<u32>());
            let args = BasicConsumeArguments::new(
                queue_name.as_str(),
                random_tag.as_str(),
            );

            self.channel.basic_consume(AckConsumerWithReply::new(), args).await?;
        }
        Ok(())
    }

    pub async fn bind_consuming(&mut self, queue_names: Vec<String>) -> Result<(), amqprs::error::Error> {
        for queue_name in queue_names {
            let random_tag = format!("consumer_tag_{}", rand::random::<u32>());
            let args = BasicConsumeArguments::new(
                queue_name.as_str(),
                random_tag.as_str(),
            );

            self.channel.basic_consume(AckConsumer::new(), args).await?;
        }
        Ok(())
    }

    pub async fn publish(&mut self, exchange_name: &str, routing_key: &str, content: String) -> Result<(), amqprs::error::Error> {
        let bytes = content.into_bytes();
        let args = BasicPublishArguments::new(exchange_name, routing_key);

        self.channel
            .basic_publish(BasicProperties::default(), bytes, args)
            .await
    }

    pub async fn publish_with_reply(&mut self, exchange_name: &str, routing_key: &str, reply_to: &str, content: String) -> Result<(), amqprs::error::Error> {
        let bytes = content.into_bytes();
        let args = BasicPublishArguments::new(exchange_name, routing_key);

        self.channel
            .basic_publish(BasicProperties::default().with_reply_to(reply_to).finish(), bytes, args)
            .await
    }
}