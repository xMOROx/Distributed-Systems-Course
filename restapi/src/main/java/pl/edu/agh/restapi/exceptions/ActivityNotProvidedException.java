package pl.edu.agh.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ActivityNotProvidedException extends RuntimeException {
    public ActivityNotProvidedException(String message) {
        super(message);
    }
}
