package pl.edu.agh.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.thymeleaf.exceptions.TemplateInputException;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomErrorHandling {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now());

        return new ResponseEntity<>(
                errorDetails,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NoResourceFoundException.class, TemplateInputException.class})
    public final ResponseEntity<ErrorDetails> handleNonEndpoint(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                "Endpoint does not exists",
                request.getDescription(false),
                LocalDateTime.now());
        return new ResponseEntity<>(
                errorDetails,
                HttpStatus.NOT_FOUND);
    }
}
