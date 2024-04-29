use std::alloc::System;
use crate::command_parser;
use std::process;

pub struct LocalCommandsHandler;

impl LocalCommandsHandler {
    pub(crate) async fn handle_command(&self, command: &command_parser::Command) -> bool {
        if command.get_command() != "!" {
            return false;
        }

        let action = command.get_action().clone().expect("Action is required");

        match action.to_lowercase().as_str() {
            "quit" => {
                println!("Quiting");
                process::exit(0);
            }
            _ => false
        }
    }
}