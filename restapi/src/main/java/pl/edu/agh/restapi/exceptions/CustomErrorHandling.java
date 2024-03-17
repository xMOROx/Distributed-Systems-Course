package pl.edu.agh.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
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
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public final ResponseEntity<ErrorDetails> handleRequiredParameterNotProvided(Exception ex, WebRequest request) {
        String parameterName = ((MissingServletRequestParameterException) ex).getParameterName();
        ErrorDetails errorDetails = new ErrorDetails(
                "Required parameter `" + parameterName + "` not provided",
                request.getDescription(false),
                LocalDateTime.now());
        return new ResponseEntity<>(
                errorDetails,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public final ResponseEntity<ErrorDetails> handleHttpClientErrorException(HttpClientErrorException ex, WebRequest request) {
        String responseMessage = ex.getResponseBodyAsString();
        String message = ex.getResponseBodyAsString()
                .substring(responseMessage.indexOf(":") + 1)
                .replaceAll("\"", "")
                .replaceAll("}", "")
                .replaceAll("\\\\", "`")
                .replaceAll("^\\[", "")
                .replaceAll("]$", "")
                .trim();

        ErrorDetails errorDetails = new ErrorDetails(
                message,
                request.getDescription(false),
                LocalDateTime.now());
        return new ResponseEntity<>(
                errorDetails,
                ex.getStatusCode());
    }

    @ExceptionHandler(ActivityNotProvidedException.class)
    public final ResponseEntity<ErrorDetails> handleActivityNotProvidedException(ActivityNotProvidedException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now());
        return new ResponseEntity<>(
                errorDetails,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public final ResponseEntity<ErrorDetails> handleUnauthorizedException(UnauthorizedException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now());
        return new ResponseEntity<>(
                errorDetails,
                HttpStatus.UNAUTHORIZED);
    }
}
