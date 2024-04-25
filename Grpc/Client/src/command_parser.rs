const DELIMITERS: [char; 2] = [' ', '\''];

pub struct CommandParser;

#[derive(Debug)]
pub struct Command {
    command: String,
    server_id: Option<String>,
    action: Option<String>,
    args: Option<Vec<String>>,
}

/// `DeviceName Server_id action [arguments]` for remote commands
/// `! command` for local commands
impl CommandParser {
    pub(crate) fn parse(raw_command: String) -> Command {
        let mut temp_command = raw_command
            .split(|c| DELIMITERS.contains(&c))
            .map(|c| c.trim())
            .filter(|c| !c.is_empty())
            .map(|c| c.to_string()).into_iter();

        let command = temp_command.next().unwrap();
        let local_command = command == "!";

        if local_command {
            let action = temp_command.next();
            Command {
                command,
                server_id: None,
                action,
                args: None,
            }
        } else {
            let server_id = temp_command.next();
            let action = temp_command.next();
            let args = temp_command.collect();

            Command {
                command,
                server_id,
                action,
                args: Some(args),
            }
        }
    }
}

impl Command {
    pub fn get_command(&self) -> &str {
        &self.command
    }

    pub fn get_action(&self) -> &Option<String> {
        &self.action
    }

    pub fn get_args(&self) -> Option<Vec<String>> {
        self.args.clone()
    }

    pub fn get_server_id(&self) -> &Option<String> {
        &self.server_id
    }
}