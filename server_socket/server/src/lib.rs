use crate::client::Client;
use std::sync::{Arc, Mutex};

pub mod client;
pub mod server;
pub type ClientStreams = Arc<Mutex<Vec<Arc<Mutex<Client>>>>>;
