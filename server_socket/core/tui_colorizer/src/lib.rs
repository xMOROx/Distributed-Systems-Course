pub enum TuiColor {
    Red,
    Green,
    Blue,
    Yellow,
    Cyan,
    Magenta,
    White,
    Black,
    Clear,
    Bold,
    Purple,
}

impl TuiColor {
    pub fn to_value(&self) -> &'static str {
        match self {
            TuiColor::Red => "\x1b[31m" as &str,
            TuiColor::Green => "\x1b[32m" as &str,
            TuiColor::Blue => "\x1b[34m" as &str,
            TuiColor::Yellow => "\x1b[33m" as &str,
            TuiColor::Cyan => "\x1b[36m" as &str,
            TuiColor::Magenta => "\x1b[35m" as &str,
            TuiColor::White => "\x1b[37m" as &str,
            TuiColor::Black => "\x1b[30m" as &str,
            TuiColor::Clear => "\x1b[0m" as &str,
            TuiColor::Bold => "\x1b[1m" as &str,
            TuiColor::Purple => "\x1b[35m" as &str,
        }
    }

    pub fn paint(&self, text: &str) -> String {
        format!("{}{}{}", self.to_value(), text, TuiColor::Clear.to_value())
    }
    pub fn bold_paint(&self, text: &str) -> String {
        format!(
            "{}{}{}",
            TuiColor::Bold.to_value(),
            self.paint(text),
            TuiColor::Clear.to_value()
        )
    }
}

#[cfg(test)]
mod tests {
    use super::*;
}
