use std::future::Future;
use crate::command_parser::Command;
pub mod local_commands;
pub mod remote_commands;

pub enum  CommandsHandler {
    LocalCommandsHandler(local_commands::LocalCommandsHandler),
    CO2LevelSensorCommandsHandler(remote_commands::CO2LevelSensorCommandsHandler),
    FridgeWithIceCubeMakerCommandsHandler(remote_commands::FridgeWithIceCubeMakerCommandsHandler),
    SmartDeviceCommandsHandler(remote_commands::SmartDeviceCommandsHandler),
    FridgeWithShoppingListCommandsHandler(remote_commands::FridgeWithShoppingListCommandsHandler),
}