const DEFAULT_NUM_OF_THREADS:u32 = 5;

pub struct Config {
    number_of_threads:u32,
}

enum ParsingError {
    NegativeNumberOfThreads,
    NonNumberPassed,
}

impl Config {
    pub fn build<T>(mut args:T) -> Self
    where 
        T: Iterator<Item = String>
    {
        args.next();
        let number_of_threads = if let Some(arg) = args.next() {
            Self::execute(arg)
        } else {
            DEFAULT_NUM_OF_THREADS
        };

        Config {
            number_of_threads
        }
    }

    pub fn get_number_of_threads(&self) -> u32 {
        self.number_of_threads
    }

    fn check_positiveness_of_argument(arg:i32) -> Result<(), ParsingError> { 
        if arg <= 0 {
            Err(ParsingError::NegativeNumberOfThreads)
        } else {
            Ok(())
        }
    }

    fn parse_argument(arg:String) -> Result<i32, ParsingError> {
        match arg.parse::<i32>() {
            Ok(value) => Ok(value),
            Err(_) => Err(ParsingError::NonNumberPassed),
        }
    }

    fn execute(arg:String) -> u32 {
        let value = if let Ok(value) = Self::parse_argument(arg) {
            value
        } else {
            panic!("Argument have to be a number");
        };

        if let Err(ParsingError::NegativeNumberOfThreads) = Self::check_positiveness_of_argument(value) {
           panic!("Argument cannot be negative"); 
        }

        value as u32
    }
} 




#[cfg(test)]
mod tests {
    use super::*;
    
    #[test]
    #[should_panic(expected = "Argument cannot be negative")]
    fn should_panic_when_argument_is_negative() {
        let args = vec!["file".to_string(), "-1".to_string()].into_iter();
        Config::build(args);
    }
    
    #[test]
    #[should_panic(expected = "Argument have to be a number")]
    fn should_panic_when_argument_is_not_a_number() {
        let args = vec!["file".to_string(), "test".to_string()].into_iter();
        Config::build(args);
    }

    #[test]
    fn is_config_with_default_number_of_threads() {
        let args = vec!["file".to_string()].into_iter();
        let config = Config::build(args);
        assert_eq!(config.get_number_of_threads(), DEFAULT_NUM_OF_THREADS);
    }
    
    #[test]
    fn is_config_with_custom_number_of_threads() {
        let args = vec!["file".to_string(), "10".to_string()].into_iter();
        let config = Config::build(args);
        assert_eq!(config.get_number_of_threads(), 10_u32);
    }
}
