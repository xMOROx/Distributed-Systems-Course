package pl.edu.agh.restapi;

import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

public record ErrorDetails(String message, String details, LocalDateTime timestamp) {
}
