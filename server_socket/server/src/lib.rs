use crate::client::Client;
use std::sync::{Arc, Mutex};

pub mod client;
pub mod server;
pub type ClientStreams = Arc<Mutex<Vec<Arc<Mutex<Client>>>>>;
pub type ClientAddresses = Arc<Mutex<Vec<ClientData>>>;
pub struct ClientData {
    pub id: usize,
    pub address: String,
}

impl ClientData {
    pub fn new(id: usize, address: String) -> Self {
        ClientData { id, address }
    }
}
