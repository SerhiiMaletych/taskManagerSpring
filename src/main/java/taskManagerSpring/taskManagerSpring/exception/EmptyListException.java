package taskManagerSpring.taskManagerSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "empty list")
public class EmptyListException extends Exception {
    public EmptyListException(String errorMessage) {
        super(errorMessage);
    }
}
