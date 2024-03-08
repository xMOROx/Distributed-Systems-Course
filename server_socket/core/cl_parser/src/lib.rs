use std::process;

const DEFAULT_NUM_OF_THREADS: usize = 5;

#[derive(Debug, Clone)]
pub struct Config {
    pub number_of_threads: usize,
    pub ip_address: String,
    pub port: String,
}

struct ArgumentParser;
struct ArgumentHelper;

enum ParsingError {
    NegativeNumberOfThreads,
    NonNumberPassed,
    NumberNotInRange,
}

impl Config {
    pub fn build<T>(args: T) -> Self
    where
        T: Iterator<Item = String>,
    {
        let config = ArgumentParser::parse(args);

        config
    }
    pub fn build_socket(&self) -> String {
        format!("{}:{}", self.ip_address, self.port)
    }

    pub fn build_udp_socket(&self) -> String {
        format!("{}:{}", self.ip_address, self.port)
    }

    pub fn build_broadcast_socket(&self) -> String {
        format!("255.255.255.255:{}", self.port)
    }
}

impl ArgumentHelper {
    pub fn display_help() {
        println!("Arguments format:");
        println!(r#"server address ip server port [number_of_threads]"#);
    }
}

impl ArgumentParser {
    pub fn parse<T>(mut args: T) -> Config
    where
        T: Iterator<Item = String>,
    {
        //skip because first argument is a filepath
        args.next();

        let mut ip_address: String = "".to_string();

        if let Some(arg) = args.next() {
            let trimmed = arg.trim();
            if trimmed == "--help" || trimmed == "-h" {
                ArgumentHelper::display_help();
                process::exit(0);
            }
            ip_address = trimmed.to_string();
        }

        let port = if let Some(arg) = args.next() {
            Self::handle_port_argument(arg)
        } else {
            panic!("Not enough number of arguments");
        };

        let number_of_threads = if let Some(arg) = args.next() {
            Self::handle_number_of_threads_argument(arg)
        } else {
            DEFAULT_NUM_OF_THREADS
        };

        Config {
            ip_address,
            port,
            number_of_threads,
        }
    }

    fn handle_port_argument(arg: String) -> String {
        let value = if let Ok(value) = Self::parse_number_argument(arg) {
            value
        } else {
            panic!("Argument have to be a number");
        };

        if let Err(ParsingError::NegativeNumberOfThreads) =
            Self::check_positiveness_of_argument(value)
        {
            panic!("Argument cannot be negative");
        }

        if let Err(ParsingError::NumberNotInRange) = Self::check_number_in_range(value) {
            panic!("Port number has to be in range 1024 to 65535");
        }
        value.to_string()
    }

    fn check_number_in_range(arg: i32) -> Result<(), ParsingError> {
        if arg < 1024 || arg > 65535 {
            Err(ParsingError::NumberNotInRange)
        } else {
            Ok(())
        }
    }

    fn check_positiveness_of_argument(arg: i32) -> Result<(), ParsingError> {
        if arg <= 0 {
            Err(ParsingError::NegativeNumberOfThreads)
        } else {
            Ok(())
        }
    }

    fn handle_number_of_threads_argument(arg: String) -> usize {
        let value = if let Ok(value) = Self::parse_number_argument(arg) {
            value
        } else {
            panic!("Argument have to be a number");
        };

        if let Err(ParsingError::NegativeNumberOfThreads) =
            Self::check_positiveness_of_argument(value)
        {
            panic!("Argument cannot be negative");
        }

        value as usize
    }

    fn parse_number_argument(arg: String) -> Result<i32, ParsingError> {
        match arg.parse::<i32>() {
            Ok(value) => Ok(value),
            Err(_) => Err(ParsingError::NonNumberPassed),
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    #[should_panic(expected = "Argument cannot be negative")]
    fn should_panic_when_argument_is_negative() {
        let args = vec![
            "file".to_string(),
            "address".to_string(),
            "8080".to_string(),
            "-1".to_string(),
        ]
        .into_iter();
        Config::build(args);
    }

    #[test]
    #[should_panic(expected = "Argument have to be a number")]
    fn should_panic_when_threads_number_argument_is_not_a_number() {
        let args = vec![
            "file".to_string(),
            "address".to_string(),
            "8080".to_string(),
            "test".to_string(),
        ]
        .into_iter();
        Config::build(args);
    }

    #[test]
    #[should_panic(expected = "Argument have to be a number")]
    fn should_panic_when_port_number_argument_is_not_a_number() {
        let args = vec![
            "file".to_string(),
            "address".to_string(),
            "port".to_string(),
            "test".to_string(),
        ]
        .into_iter();
        Config::build(args);
    }

    #[test]
    #[should_panic(expected = "Port number has to be in range 1024 to 65535")]
    fn should_panic_when_port_number_is_not_in_range() {
        let args = vec![
            "file".to_string(),
            "address".to_string(),
            "1023".to_string(),
            "test".to_string(),
        ]
        .into_iter();
        Config::build(args);
    }

    #[test]
    fn is_config_with_default_number_of_threads() {
        let args = vec![
            "file".to_string(),
            "address".to_string(),
            "8080".to_string(),
        ]
        .into_iter();
        let config = Config::build(args);
        assert_eq!(config.number_of_threads, DEFAULT_NUM_OF_THREADS);
    }

    #[test]
    fn is_config_with_custom_number_of_threads() {
        let args = vec![
            "file".to_string(),
            "address".to_string(),
            "8080".to_string(),
            "10".to_string(),
        ]
        .into_iter();
        let config = Config::build(args);
        assert_eq!(config.number_of_threads, 10_usize);
    }
}
