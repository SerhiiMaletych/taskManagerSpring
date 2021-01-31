package taskManagerSpring.taskManagerSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NO_CONTENT, reason = "no data! Add something")

public class EmptyDataException extends Exception {
    public EmptyDataException(String errorMessage) {
        super(errorMessage);
    }
}
