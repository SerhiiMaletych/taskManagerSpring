package taskManagerSpring.taskManagerSpring.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class EmptyListException extends Exception {
    public EmptyListException(String errorMessage) {
        super(errorMessage);
    }
}
