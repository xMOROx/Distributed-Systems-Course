use std::collections::HashMap;
use proto::fridge_with_ice_cube_maker_client::FridgeWithIceCubeMakerClient;
use crate::command_handler::{CommandsHandler, local_commands::LocalCommandsHandler, remote_commands::*};

mod proto {
    tonic::include_proto!("smart_home");
}

mod command_parser;
mod command_handler;

mod settings {
    pub const IP_ADDRESS: &str = "http://127.0.0.!!";
    pub const PORT: &str = "50051";
}


#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    let mut handlers: HashMap<String, CommandsHandler> = HashMap::new();

    handlers.insert("!".to_string(), CommandsHandler::LocalCommandsHandler(LocalCommandsHandler));
    handlers.insert("CO2LevelSensor".to_string(), CommandsHandler::CO2LevelSensorCommandsHandler(CO2LevelSensorCommandsHandler));
    handlers.insert("FridgeWithIceCubeMaker".to_string(), CommandsHandler::FridgeWithIceCubeMakerCommandsHandler(FridgeWithIceCubeMakerCommandsHandler));
    handlers.insert("SmartDevice".to_string(), CommandsHandler::SmartDeviceCommandsHandler(SmartDeviceCommandsHandler));
    handlers.insert("FridgeWithShoppingList".to_string(), CommandsHandler::FridgeWithShoppingListCommandsHandler(FridgeWithShoppingListCommandsHandler));

    loop {
        println!("Enter command: ");
        let mut input = String::new();
        std::io::stdin().read_line(&mut input).unwrap();
        let mut handled = false;
        let command = command_parser::CommandParser::parse(input);

        println!("Command: {:?}", command);

        let handler =  handlers.get(command.get_command());
        if let Some(handler) = handler {
            match handler {
                CommandsHandler::LocalCommandsHandler(handler) => {
                    handler.handle_command(&command).await.expect("TODO: panic message");
                    handled = true;
                }
                CommandsHandler::CO2LevelSensorCommandsHandler(handler) => {
                    handler.handle_command(&command).await.expect("TODO: panic message");
                    handled = true;
                }
                CommandsHandler::FridgeWithIceCubeMakerCommandsHandler(handler) => {
                    handler.handle_command(&command).await.expect("TODO: panic message");
                    handled = true;
                }
                CommandsHandler::SmartDeviceCommandsHandler(handler) => {
                    handler.handle_command(&command).await.expect("TODO: panic message");
                    handled = true;
                }
                CommandsHandler::FridgeWithShoppingListCommandsHandler(handler) => {
                    handler.handle_command(&command).await.expect("TODO: panic message");
                    handled = true;
                }
            }
        }

        if !handled {
            println!("Couldn't find a handler to handle the command");
        }
    }
    Ok(())
}
