package taskManagerSpring.taskManagerSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.I_AM_A_TEAPOT, reason = "wrong teapot=)")
public class WrongIdException extends Exception {
    public WrongIdException(String errorMessage) {
        super(errorMessage);
    }
}
