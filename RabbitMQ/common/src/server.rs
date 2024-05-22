use std::collections::HashMap;
use std::fmt::format;
use amqprs::{AmqpMessageCount, channel};
use amqprs::channel::{ExchangeBindArguments, ExchangeType, QueueBindArguments, QueueDeclareArguments};
use amqprs::connection::{Connection, OpenConnectionArguments};
use crate::Operations;

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


pub struct Server {
    pub connection: Connection,
    pub channel: channel::Channel,
    pub exchanges: Vec<String>,
    pub queues: Vec<String>,
}

impl Server {
    pub fn build(request: ConnectionRequest) -> Server {
        let connection = Connection::open(&OpenConnectionArguments::new(
            request.ip.as_str(),
            RABBITMQ_PORT,
            request.username.as_str(),
            request.password.as_str(),
        ))
            .expect("Failed to connect to RabbitMQ");

        let channel = connection.open_channel(None)
            .expect("Failed to open channel");

        Self::set_qos(&channel)
            .expect("Failed to set QoS");

        Server {
            connection,
            channel,
            exchanges: Vec::new(),
            queues: Vec::new(),
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

    fn set_qos(channel: &channel::Channel) -> Result<(), amqprs::error::Error> {
        let args = channel::BasicQosArguments {
            prefetch_size: 0,
            prefetch_count: 1,
            global: false,
        };

        channel.basic_qos(args)?
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
}