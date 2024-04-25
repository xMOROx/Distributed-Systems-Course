use tonic::{GrpcMethod, IntoRequest, Request, Response, Status};
use tonic::codegen::{http, StdError};
use tonic::transport::Channel;
use crate::command_parser::Command;
use crate::settings::{IP_ADDRESS, PORT};
use crate::proto::{self, Void, smart_device_client::SmartDeviceClient, co2_level_sensor_client::Co2LevelSensorClient, fridge_client::FridgeClient, fridge_with_ice_cube_maker_client::FridgeWithIceCubeMakerClient, fridge_with_shopping_list_client::FridgeWithShoppingListClient, ModeMessage, Temperature};
use crate::proto::smart_device_server::SmartDevice;


struct SmartDeviceCommandsHandler;

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

fn get_url(server_id: &str) -> String

{
    let ip_address = IP_ADDRESS.replace("!!", &*server_id);
    let url = format!("{}:{}", ip_address, PORT);

    url
}

impl SmartDeviceCommandsHandler {
    pub(crate) async fn handle_command(&self, command: &Command) -> bool {
        if command.get_server_id().is_none() {
            return false;
        }


        let mut client = match SmartDeviceClient::connect(get_url(command.get_server_id().clone().unwrap().as_str())).await {
            Ok(client) => {
                println!("Connected to server on url {:?}", format!("{}/{}", IP_ADDRESS.replace("!!", command.get_server_id().clone().unwrap().as_str()), PORT));
                client
            }
            Err(e) => {
                println!("Failed to connect to server because of: {:?}", e);
                return false;
            }
        };


        let action = match command.get_action().clone() {
            Some(action) => action,
            None => {
                println!("Action is required");
                return false;
            }
        };

        SmartDeviceCommandsHandler::choose_action(action.as_str(), command, &mut client).await
    }

    pub(super) async fn choose_action(action: &str, command: &Command, client: &mut SmartDeviceClient<Channel>) -> bool
    {
        match action {
            "getMode" => {
                let request = tonic::Request::new(Void {});

                let response = match client.get_mode(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get mode because of: {:?}", e.message());
                        return false;
                    }
                };


                let mode = response.get_ref().mode;
                println!("The device is currently in the: {:?} mode", mode);
                true
            }
            "setMode" => {
                let request = tonic::Request::new(ModeMessage {
                    mode: match from_str_to_i32(match command.get_args().expect("").get(0) {
                        Some(mode) => mode,
                        None => {
                            println!("Mode is required");
                            return false;
                        }
                    }) {
                        Ok(mode) => mode,
                        Err(e) => {
                            println!("{:?}", e);
                            return false;
                        }
                    }
                });

                let response = match client.set_mode(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to set mode because of: {:?}", e.message());
                        return false;
                    }
                };

                let mode = response.get_ref().mode;
                println!("Set the device to the: {:?} mode", mode);
                true
            }
            _ => false,
        }
    }
}

impl CO2LevelSensorCommandsHandler {
    pub(crate) async fn handle_command(&self, command: &Command) -> bool {
        if command.get_server_id().is_none() {
            return false;
        }

        let mut client = match Co2LevelSensorClient::connect(get_url(command.get_server_id().clone().unwrap().as_str())).await {
            Ok(client) => {
                println!("Connected to server on url {:?}", format!("{}/{}", IP_ADDRESS.replace("!!", command.get_server_id().clone().unwrap().as_str()), PORT));
                client
            }
            Err(e) => {
                println!("Failed to connect to server because of: {:?}", e);
                return false;
            }
        };

        let action = match command.get_action().clone() {
            Some(action) => action,
            None => {
                println!("Action is required");
                return false;
            }
        };


        CO2LevelSensorCommandsHandler::choose_action(action.as_str(), command, &mut client).await
    }

    pub(super) async fn choose_action(action: &str, command: &Command, client: &mut Co2LevelSensorClient<Channel>) -> bool {
        match action {
            "getMode" => {
                let request = tonic::Request::new(Void {});

                let response = match client.get_mode(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get mode because of: {:?}", e.message());
                        return false;
                    }
                };


                let mode = response.get_ref().mode;
                println!("The device is currently in the: {:?} mode", mode);
                true
            }
            "setMode" => {
                let request = tonic::Request::new(ModeMessage {
                    mode: match from_str_to_i32(match command.get_args().expect("").get(0) {
                        Some(mode) => mode,
                        None => {
                            println!("Mode is required");
                            return false;
                        }
                    }) {
                        Ok(mode) => mode,
                        Err(e) => {
                            println!("{:?}", e);
                            return false;
                        }
                    }
                });

                let response = match client.set_mode(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to set mode because of: {:?}", e.message());
                        return false;
                    }
                };

                let mode = response.get_ref().mode;
                println!("Set the device to the: {:?} mode", mode);
                true
            }
            "getCO2LevelInPPM" => {
                let request = tonic::Request::new(Void {});
                let response = match client.get_co2_level_in_ppm(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get CO2 level because of: {:?}", e.message());
                        return false;
                    }
                };

                let co2_level = response.get_ref().ppm;
                println!("CO2 level is: {:?}", co2_level);
                true
            }
            "isCO2LevelSafe" => {
                let request = tonic::Request::new(Void {});

                let response = match client.is_co2_level_safe(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to check if CO2 level is safe because of: {:?}", e.message());
                        return false;
                    }
                };

                let safe = response.get_ref().safe;
                println!("CO2 level is safe: {:?}", if safe { "Yes" } else { "No" });
                true
            }
            _ => false
        }
    }
}

impl FridgeCommandsHandler {
    pub async fn handle_command(&self, command: &Command) -> bool {
        if command.get_server_id().is_none() {
            return false;
        }

        let mut client = match FridgeClient::connect(get_url(command.get_server_id().clone().unwrap().as_str())).await {
            Ok(client) => {
                println!("Connected to server on url {:?}", format!("{}/{}", IP_ADDRESS.replace("!!", command.get_server_id().clone().unwrap().as_str()), PORT));
                client
            }
            Err(e) => {
                println!("Failed to connect to server because of: {:?}", e);
                return false;
            }
        };

        let action = match command.get_action().clone() {
            Some(action) => action,
            None => {
                println!("Action is required");
                return false;
            }
        };


        FridgeCommandsHandler::choose_action(action.as_str(), command, &mut client).await
    }

    pub(super) async fn choose_action(action: &str, command: &Command, client: &mut FridgeClient<Channel>) -> bool {
        match action {
            "getMode" => {
                let request = tonic::Request::new(Void {});

                let response = match client.get_mode(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get mode because of: {:?}", e.message());
                        return false;
                    }
                };


                let mode = response.get_ref().mode;
                println!("The device is currently in the: {:?} mode", mode);
                true
            }
            "setMode" => {
                let request = tonic::Request::new(ModeMessage {
                    mode: match from_str_to_i32(match command.get_args().expect("").get(0) {
                        Some(mode) => mode,
                        None => {
                            println!("Mode is required");
                            return false;
                        }
                    }) {
                        Ok(mode) => mode,
                        Err(e) => {
                            println!("{:?}", e);
                            return false;
                        }
                    }
                });

                let response = match client.set_mode(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to set mode because of: {:?}", e.message());
                        return false;
                    }
                };

                let mode = response.get_ref().mode;
                println!("Set the device to the: {:?} mode", mode);
                true
            }
            "setTargetTemperature" => {
                let request = tonic::Request::new(Temperature {
                    temperature: match command.get_args().expect("").get(0) {
                        Some(temperature) => match temperature.parse() {
                            Ok(temperature) => temperature,
                            Err(_) => {
                                println!("Invalid temperature");
                                return false;
                            }
                        }
                        None => {
                            println!("Temperature is required");
                            return false;
                        }
                    }
                });

                let response =
                    match client.set_target_temperature(request).await {
                        Ok(response) => response,
                        Err(e) => {
                            println!("Failed to set target temperature because of: {:?}", e.message());
                            return false;
                        }
                    };


                let temperature = response.get_ref().temperature;

                println!("Set the target temperature to: {:?}", temperature);

                true
            }
            "getTargetTemperature" => {
                let request = tonic::Request::new(Void {});

                let response = match client.get_target_temperature(request).await
                {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get target temperature because of: {:?}", e.message());
                        return false;
                    }
                };

                let temperature = response.get_ref().temperature;

                println!("The target temperature is: {:?}", temperature);

                true
            }
            "getCurrentTemperature" => {
                let request = tonic::Request::new(Void {});

                let response = match client.get_current_temperature(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get current temperature because of: {:?}", e.message());
                        return false;
                    }
                };

                let temperature = response.get_ref().temperature;

                println!("The current temperature is: {:?}", temperature);

                true
            }
            _ => false,
        }
    }
}

impl FridgeWithIceCubeMakerCommandsHandler {
    pub(crate) async fn handle_command(&self, command: &Command) -> bool {
        if command.get_server_id().is_none() {
            return false;
        }

        let mut client = match FridgeWithIceCubeMakerClient::connect(get_url(command.get_server_id().clone().unwrap().as_str())).await {
            Ok(client) => {
                println!("Connected to server on url {:?}", format!("{}/{}", IP_ADDRESS.replace("!!", command.get_server_id().clone().unwrap().as_str()), PORT));

                client
            }
            Err(e) => {
                println!("Failed to connect to server because of: {:?}", e);
                return false;
            }
        };

        let action = match command.get_action().clone() {
            Some(action) => action,
            None => {
                println!("Action is required");
                return false;
            }
        };

        FridgeWithIceCubeMakerCommandsHandler::choose_action(action.as_str(), command, &mut client).await
    }

    pub(super) async fn choose_action(action: &str, command: &Command, client: &mut FridgeWithIceCubeMakerClient<Channel>) -> bool {
        match action {
            "getMode" => {
                let request = tonic::Request::new(Void {});

                let response = match client.get_mode(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get mode because of: {:?}", e.message());
                        return false;
                    }
                };


                let mode = response.get_ref().mode;
                println!("The device is currently in the: {:?} mode", mode);
                true
            }
            "setMode" => {
                let request = tonic::Request::new(ModeMessage {
                    mode: match from_str_to_i32(match command.get_args().expect("").get(0) {
                        Some(mode) => mode,
                        None => {
                            println!("Mode is required");
                            return false;
                        }
                    }) {
                        Ok(mode) => mode,
                        Err(e) => {
                            println!("{:?}", e);
                            return false;
                        }
                    }
                });

                let response = match client.set_mode(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to set mode because of: {:?}", e.message());
                        return false;
                    }
                };

                let mode = response.get_ref().mode;
                println!("Set the device to the: {:?} mode", mode);
                true
            }
            "setTargetTemperature" => {
                let request = tonic::Request::new(Temperature {
                    temperature: match command.get_args().expect("").get(0) {
                        Some(temperature) => match temperature.parse() {
                            Ok(temperature) => temperature,
                            Err(_) => {
                                println!("Invalid temperature");
                                return false;
                            }
                        }
                        None => {
                            println!("Temperature is required");
                            return false;
                        }
                    }
                });

                let response =
                    match client.set_target_temperature(request).await {
                        Ok(response) => response,
                        Err(e) => {
                            println!("Failed to set target temperature because of: {:?}", e.message());
                            return false;
                        }
                    };


                let temperature = response.get_ref().temperature;

                println!("Set the target temperature to: {:?}", temperature);

                true
            }
            "getTargetTemperature" => {
                let request = tonic::Request::new(Void {});

                let response = match client.get_target_temperature(request).await
                {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get target temperature because of: {:?}", e.message());
                        return false;
                    }
                };

                let temperature = response.get_ref().temperature;

                println!("The target temperature is: {:?}", temperature);

                true
            }
            "getCurrentTemperature" => {
                let request = tonic::Request::new(Void {});

                let response = match client.get_current_temperature(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get current temperature because of: {:?}", e.message());
                        return false;
                    }
                };

                let temperature = response.get_ref().temperature;

                println!("The current temperature is: {:?}", temperature);

                true
            }
            "getIceCubesMakerCapacity" => {
                let request = tonic::Request::new(Void {});

                let response = match client.get_ice_cubes_maker_capacity(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get ice cubes maker capacity because of: {:?}", e.message());
                        return false;
                    }
                };


                let ice_cubes_maker_capacity = response.get_ref().ice_cubes;

                println!("The ice cubes maker capacity is: {:?}", ice_cubes_maker_capacity);

                true
            }
            "getIceCubes" => {
                let request = tonic::Request::new(proto::IceCubesMaker {
                    ice_cubes: match command.get_args().expect("").get(0) {
                        Some(ice_cubes) => match ice_cubes.parse() {
                            Ok(ice_cubes) => ice_cubes,
                            Err(_) => {
                                println!("Invalid ice cubes");
                                return false;
                            }
                        }
                        None => {
                            println!("Ice cubes is required");
                            return false;
                        }
                    }
                });

                let response = match client.get_ice_cubes(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get ice cubes because of: {:?}", e.message());
                        return false;
                    }
                };


                let ice_cubes = response.get_ref().ice_cubes;

                println!("The received amount of ice cubes is: {:?}", ice_cubes);

                true
            }
            "getIceCubesCount" => {
                let request = tonic::Request::new(Void {});

                let response = match client.get_ice_cubes_count(request).await
                {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get ice cubes count because of: {:?}", e.message());
                        return false;
                    }
                };

                let ice_cubes_count = response.get_ref().ice_cubes;

                println!("There is {:?} ice cubes in the ice cubes maker", ice_cubes_count);

                true
            }
            _ => false,
        }
    }
}

impl FridgeWithShoppingListCommandsHandler {
    pub(crate) async fn handle_command(&self, command: &Command) -> bool {
        if command.get_server_id().is_none() {
            return false;
        }

        let mut client = match FridgeWithShoppingListClient::connect(get_url(command.get_server_id().clone().unwrap().as_str())).await {
            Ok(client) => {
                println!("Connected to server on url {:?}", format!("{}/{}", IP_ADDRESS.replace("!!", command.get_server_id().clone().unwrap().as_str()), PORT));

                client
            }
            Err(e) => {
                println!("Failed to connect to server because of: {:?}", e);
                return false;
            }
        };

        let action = match command.get_action().clone() {
            Some(action) => action,
            None => {
                println!("Action is required");
                return false;
            }
        };


        FridgeWithShoppingListCommandsHandler::choose_action(action.as_str(), command, &mut client).await
    }

    pub(super) async fn choose_action(action: &str, command: &Command, client: &mut FridgeWithShoppingListClient<Channel>) -> bool {
        match action {
            "getMode" => {
                let request = tonic::Request::new(Void {});

                let response = match client.get_mode(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get mode because of: {:?}", e.message());
                        return false;
                    }
                };


                let mode = response.get_ref().mode;
                println!("The device is currently in the: {:?} mode", mode);
                true
            }
            "setMode" => {
                let request = tonic::Request::new(ModeMessage {
                    mode: match from_str_to_i32(match command.get_args().expect("").get(0) {
                        Some(mode) => mode,
                        None => {
                            println!("Mode is required");
                            return false;
                        }
                    }) {
                        Ok(mode) => mode,
                        Err(e) => {
                            println!("{:?}", e);
                            return false;
                        }
                    }
                });

                let response = match client.set_mode(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to set mode because of: {:?}", e.message());
                        return false;
                    }
                };

                let mode = response.get_ref().mode;
                println!("Set the device to the: {:?} mode", mode);
                true
            }
            "setTargetTemperature" => {
                let request = tonic::Request::new(Temperature {
                    temperature: match command.get_args().expect("").get(0) {
                        Some(temperature) => match temperature.parse() {
                            Ok(temperature) => temperature,
                            Err(_) => {
                                println!("Invalid temperature");
                                return false;
                            }
                        }
                        None => {
                            println!("Temperature is required");
                            return false;
                        }
                    }
                });

                let response =
                    match client.set_target_temperature(request).await {
                        Ok(response) => response,
                        Err(e) => {
                            println!("Failed to set target temperature because of: {:?}", e.message());
                            return false;
                        }
                    };


                let temperature = response.get_ref().temperature;

                println!("Set the target temperature to: {:?}", temperature);

                true
            }
            "getTargetTemperature" => {
                let request = tonic::Request::new(Void {});

                let response = match client.get_target_temperature(request).await
                {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get target temperature because of: {:?}", e.message());
                        return false;
                    }
                };

                let temperature = response.get_ref().temperature;

                println!("The target temperature is: {:?}", temperature);

                true
            }
            "getCurrentTemperature" => {
                let request = tonic::Request::new(Void {});

                let response = match client.get_current_temperature(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get current temperature because of: {:?}", e.message());
                        return false;
                    }
                };

                let temperature = response.get_ref().temperature;

                println!("The current temperature is: {:?}", temperature);

                true
            }
            "getShoppingList" => {
                let request = tonic::Request::new(Void {});

                let response = match client.get_shopping_list(request).await {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to get shopping list because of: {:?}", e.message());
                        return false;
                    }
                };


                let shopping_list = response.get_ref().shopping_list_record.clone();
                println!("BEGIN Shopping list:");
                for record in shopping_list {
                    for one_product in record.shopping_list_record {
                        println!("Product: {:?}, Quantity: {:?}, Unit: {:?}", one_product.name, one_product.quantity, Self::from_i32_to_str(one_product.unit));
                    }
                }
                println!("END Shopping list");

                true
            }
            "addShoppingListRecord" => {
                let name = match command.get_args().expect("").get(0) {
                    Some(name) => name.clone(),
                    None => {
                        println!("Name is required");
                        return false;
                    }
                };

                let quantity = match command.get_args().expect("").get(1)
                {
                    Some(quantity) => match quantity.parse() {
                        Ok(quantity) => quantity,
                        Err(_) => {
                            println!("Invalid quantity");
                            return false;
                        }
                    }
                    None => {
                        println!("Quantity is required");
                        return false;
                    }
                };

                let unit = Self::from_str_to_i32(match command.get_args().expect("").get(2)
                {
                    Some(unit) => unit.clone(),
                    None => {
                        println!("Unit is required");
                        return false;
                    }
                });

                let to_added = proto::ShoppingListRecord {
                    name,
                    quantity,
                    unit,
                };

                let request = tonic::Request::new(to_added);

                let response = match client.add_shopping_list_record(request).await
                {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to add shopping list record because of: {:?}", e.message());
                        return false;
                    }
                };

                let shopping_list = response.get_ref().clone();
                println!("Added the record to the shopping list:");
                println!("Product: {:?}, Quantity: {:?}, Unit: {:?}", shopping_list.name, shopping_list.quantity, Self::from_i32_to_str(shopping_list.unit));

                true
            }
            "removeShoppingListRecord" => {
                let id_to_remove = match command.get_args().expect("").get(0) {
                    Some(id) => match id.parse() {
                        Ok(id) => id,
                        Err(_) => {
                            println!("Invalid id");
                            return false;
                        }
                    }
                    None => {
                        println!("Id is required");
                        return false;
                    }
                };

                let request = tonic::Request::new(proto::FridgeRemoveShopping {
                    id: id_to_remove,
                });

                let response = match client.remove_shopping_list_record(request).await
                {
                    Ok(response) => response,
                    Err(e) => {
                        println!("Failed to remove shopping list record because of: {:?}", e.message());
                        return false;
                    }
                };

                let shopping_list = response.get_ref().clone();

                println!("Removed the record from the shopping list:");
                println!("Product: {:?}, Quantity: {:?}, Unit: {:?}", shopping_list.name, shopping_list.quantity, Self::from_i32_to_str(shopping_list.unit));

                true
            }
            _ => false,
        }
    }
    fn from_str_to_i32(unit: String) -> i32 {
        match unit.to_lowercase().as_str() {
            "gram" => 1,
            "millilitre" => 2,
            "unspecified" | _ => 0,
        }
    }

    fn from_i32_to_str(unit: i32) -> String {
        match unit {
            1 => "gram".to_string(),
            2 => "millilitre".to_string(),
            _ => "unspecified".to_string(),
        }
    }
}
