
mod proto {
    tonic::include_proto!("SmartHome");
}


#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    let url = "http://[::1]:50051";

    Ok(())
}
