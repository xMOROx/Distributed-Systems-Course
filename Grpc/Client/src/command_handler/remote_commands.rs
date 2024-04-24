use crate::command_parser::Command;
use crate::settings::{IP_ADDRESS, PORT};
use crate::proto::{self, Void, smart_device_client::SmartDeviceClient, co2_level_sensor_client::Co2LevelSensorClient, fridge_client::FridgeClient, fridge_with_ice_cube_maker_client::FridgeWithIceCubeMakerClient, fridge_with_shopping_list_client::FridgeWithShoppingListClient, ModeMessage, Temperature};


pub struct SmartDeviceCommandsHandler;

pub struct CO2LevelSensorCommandsHandler;

pub struct FridgeCommandsHandler;

pub struct FridgeWithIceCubeMakerCommandsHandler;

pub struct FridgeWithShoppingListCommandsHandler;


fn from_str_to_i32(mode: &str) -> Result<i32, String> {
    match mode.to_lowercase().as_str() {
        "on" => Ok(0),
        "standby" => Ok(1),
        _ => Err("Invalid mode".to_string()),
    }
}

impl SmartDeviceCommandsHandler {
    pub(crate) async fn handle_command(&self, command: &Command) -> Result<bool, String> {
        if (command.get_server_id().is_none()) {
            return Ok(false);
        }

        let server_id = command.get_server_id().clone()
            .expect("Server ID is required");

        let ip_address = IP_ADDRESS.replace("!!", &*server_id);
        let url = format!("{}:{}", IP_ADDRESS, PORT);

        let mut client = SmartDeviceClient::connect(url).await
            .expect("Failed to connect to server");

        let action = command.get_action().clone().expect("Action is required");

        match action.as_str() {
            "getMode" => {
                let request = tonic::Request::new(Void {});
                let response = client.get_mode(request).await
                    .expect("Failed to get mode");

                let mode = response.get_ref().mode;
                println!("The device is currently in the: {:?} mode", mode);
                Ok(true)
            }
            "setMode" => {
                let request = tonic::Request::new(ModeMessage {
                    mode: from_str_to_i32(command.get_args().expect("").get(0).expect("Mode is required"))
                        .expect("Invalid mode"),
                });

                let response = client.set_mode(request).await
                    .expect("Failed to set mode");

                let mode = response.get_ref().mode;
                println!("Set the device to the: {:?} mode", mode);
                Ok(true)
            }
            _ => Ok(false),
        }
    }
}

impl CO2LevelSensorCommandsHandler {
    pub(crate) async fn handle_command(&self, command: &Command) -> Result<bool, String> {
        if (command.get_server_id().is_none()) {
            return Ok(false);
        }

        let server_id = command.get_server_id().clone()
            .expect("Server ID is required");

        let ip_address = IP_ADDRESS.replace("!!", &*server_id);
        let url = format!("{}:{}", ip_address, PORT);

        println!("Connecting to: {:?}", url);

        let mut client = Co2LevelSensorClient::connect(url).await
            .expect("Failed to connect to server");

        let action = command.get_action().clone().expect("Action is required");

        match action.as_str() {
            "getCO2LevelInPPM" => {
                let request = tonic::Request::new(Void {});
                let response = client.get_co2_level_in_ppm(request).await
                    .expect("Failed to get co2 level");

                let co2_level = response.get_ref().ppm;
                println!("CO2 level is: {:?}", co2_level);
                Ok(true)
            }
            "isCO2LevelSafe" => {
                let request = tonic::Request::new(Void {});

                let response = client.is_co2_level_safe(request).await
                    .expect("Failed to check if CO2 level is safe");

                let safe = response.get_ref().safe;
                println!("CO2 level is safe: {:?}", if safe { "Yes" } else { "No" });
                Ok(true)
            }
            _ => Ok(false),
        }
    }
}

impl FridgeCommandsHandler {
    async fn handle_command(&self, command: &Command) -> Result<bool, String> {
        if (command.get_server_id().is_none()) {
            return Ok(false);
        }

        let server_id = command.get_server_id().clone()
            .expect("Server ID is required");

        let ip_address = IP_ADDRESS.replace("!!", &*server_id);
        let url = format!("{}:{}", IP_ADDRESS, PORT);

        let mut client = FridgeClient::connect(url).await
            .expect("Failed to connect to server");

        let action = command.get_action().clone().expect("Action is required");

        match action.as_str() {
            "setTargetTemperature" => {
                let request = tonic::Request::new(Temperature {
                    temperature: command.get_args().expect("").get(0).unwrap().parse().expect("Invalid temperature"),
                });

                let response = client.set_target_temperature(request).await
                    .expect("Failed to set target temperature");

                let temperature = response.get_ref().temperature;

                println!("Set the target temperature to: {:?}", temperature);

                Ok(true)
            }
            "getTargetTemperature" => {
                let request = tonic::Request::new(Void {});

                let response = client.get_target_temperature(request).await
                    .expect("Failed to get target temperature");

                let temperature = response.get_ref().temperature;

                println!("The target temperature is: {:?}", temperature);

                Ok(true)
            }
            "getCurrentTemperature" => {
                let request = tonic::Request::new(Void {});

                let response = client.get_current_temperature(request).await
                    .expect("Failed to get current temperature");

                let temperature = response.get_ref().temperature;

                println!("The current temperature is: {:?}", temperature);

                Ok(true)
            }
            _ => Ok(false),
        }
    }
}

impl FridgeWithIceCubeMakerCommandsHandler {
    pub(crate) async fn handle_command(&self, command: &Command) -> Result<bool, String> {
        if (command.get_server_id().is_none()) {
            return Ok(false);
        }

        let server_id = command.get_server_id().clone()
            .expect("Server ID is required");

        let ip_address = IP_ADDRESS.replace("!!", &*server_id);
        let url = format!("{}:{}", IP_ADDRESS, PORT);

        let mut client = FridgeWithIceCubeMakerClient::connect(url).await
            .expect("Failed to connect to server");

        let action = command.get_action().clone().expect("Action is required");

        match action.as_str() {
            "getIceCubesMakerCapacity" => {
                let request = tonic::Request::new(Void {});

                let response = client.get_ice_cubes_maker_capacity(request).await
                    .expect("Failed to get  ice cubes maker capacity");

                let ice_cubes_maker_capacity = response.get_ref().ice_cubes;

                println!("The ice cubes maker capacity is: {:?}", ice_cubes_maker_capacity);

                Ok(true)
            }
            "getIceCubes" => {
                let request = tonic::Request::new(proto::IceCubesMaker {
                    ice_cubes: command.get_args().expect("").get(0).unwrap().parse().expect("Invalid ice cubes"),
                });

                let response = client.get_ice_cubes(request).await
                    .expect("Failed to get ice cubes");

                let ice_cubes = response.get_ref().ice_cubes;

                println!("The received amount of ice cubes is: {:?}", ice_cubes);

                Ok(true)
            }
            "getIceCubesCount" => {
                let request = tonic::Request::new(Void {});

                let response = client.get_ice_cubes_count(request).await
                    .expect("Failed to get ice cubes count");

                let ice_cubes_count = response.get_ref().ice_cubes;

                println!("There is {:?} ice cubes in the ice cubes maker", ice_cubes_count);

                Ok(true)
            }
            _ => Ok(false),
        }
    }
}

impl FridgeWithShoppingListCommandsHandler {
    pub(crate) async fn handle_command(&self, command: &Command) -> Result<bool, String> {
        if (command.get_server_id().is_none()) {
            return Ok(false);
        }

        let server_id = command.get_server_id().clone()
            .expect("Server ID is required");

        let ip_address = IP_ADDRESS.replace("!!", &*server_id);
        let url = format!("{}:{}", IP_ADDRESS, PORT);

        let mut client = FridgeWithShoppingListClient::connect(url).await
            .expect("Failed to connect to server");

        let action = command.get_action().clone().expect("Action is required");

        match action.as_str() {
            "getShoppingList" => {
                let request = tonic::Request::new(Void {});

                let response = client.get_shopping_list(request).await
                    .expect("Failed to get shopping list");

                let shopping_list = response.get_ref().shopping_list_record.clone();
                println!("BEGIN Shopping list:");
                for record in shopping_list {
                    for one_product in record.shopping_list_record {
                        println!("Product: {:?}, Quantity: {:?}, Unit: {:?}", one_product.name, one_product.quantity, one_product.unit);
                    }
                }
                println!("END Shopping list");

                Ok(true)
            }
            "addShoppingListRecord" => {
                let name = command.get_args().expect("").get(0).expect("Name is required").clone();
                let quantity = command.get_args().expect("").get(1).expect("Quantity is required").parse().expect("Invalid quantity");
                let unit = command.get_args().expect("").get(2).expect("Unit is required").clone().parse().expect("Invalid unit");

                let to_added = proto::ShoppingListRecord {
                    name,
                    quantity,
                    unit,
                };

                let request = tonic::Request::new(to_added);

                let response = client.add_shopping_list_record(request).await
                    .expect("Failed to add shopping list record");

                let shopping_list = response.get_ref().clone();
                println!("Added the record to the shopping list:");
                println!("Product: {:?}, Quantity: {:?}, Unit: {:?}", shopping_list.name, shopping_list.quantity, shopping_list.unit);

                Ok(true)
            }
            "removeShoppingListRecord" => {
                let id_to_remove = command.get_args().expect("").get(0).expect("ID is required").parse().expect("Invalid ID");

                let request = tonic::Request::new(proto::FridgeRemoveShopping {
                    id: id_to_remove,
                });

                let response = client.remove_shopping_list_record(request).await
                    .expect("Failed to remove shopping list record");

                let shopping_list = response.get_ref().clone();

                println!("Removed the record from the shopping list:");
                println!("Product: {:?}, Quantity: {:?}, Unit: {:?}", shopping_list.name, shopping_list.quantity, shopping_list.unit);

                Ok(true)
            }
            _ => Ok(false),
        }
    }
}
