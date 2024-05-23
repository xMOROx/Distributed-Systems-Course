use std::str::FromStr;

pub mod server;


#[derive(Clone, Copy, Debug, PartialEq)]
pub enum Operations {
    Hip,
    Knee,
    Elbow,
}

impl FromStr for Operations {
    type Err = ();

    fn from_str(s: &str) -> Result<Self, Self::Err> {
        match s.to_lowercase().as_str() {
            "hip" => Ok(Operations::Hip),
            "knee" => Ok(Operations::Knee),
            "elbow" => Ok(Operations::Elbow),
            _ => Err(())
        }
    }
}


impl From<String> for Operations {
    fn from(s: String) -> Self {
        match s.to_lowercase().as_str() {
            "hip" => Operations::Hip,
            "knee" => Operations::Knee,
            "elbow" => Operations::Elbow,
            _ => panic!("Invalid operation")
        }
    }
}

impl From<&str> for Operations {
    fn from(s: &str) -> Self {
        match s.to_lowercase().as_str() {
            "hip" => Operations::Hip,
            "knee" => Operations::Knee,
            "elbow" => Operations::Elbow,
            _ => panic!("Invalid operation")
        }
    }
}

impl Into<String> for Operations {
    fn into(self) -> String {
        match self {
            Operations::Hip => "hip".to_string(),
            Operations::Knee => "knee".to_string(),
            Operations::Elbow => "elbow".to_string(),
        }
    }
}


#[cfg(test)]
mod tests {
    use super::*;
}
