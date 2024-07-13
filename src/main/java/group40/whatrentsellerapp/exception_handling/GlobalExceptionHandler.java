package group40.whatrentsellerapp.exception_handling;

import group40.whatrentsellerapp.exception_handling.exceptions.AlreadyExistException;
import group40.whatrentsellerapp.exception_handling.exceptions.CustomValidationException;
import group40.whatrentsellerapp.exception_handling.exceptions.IsEmptyException;
import group40.whatrentsellerapp.exception_handling.exceptions.NotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<String> handleAlreadyExistException(AlreadyExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<String> handleValidationException(CustomValidationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {

        StringBuilder responseMessage = new StringBuilder();

        e.getConstraintViolations().forEach(constraintViolation -> {
            String message = constraintViolation.getMessage();
            responseMessage.append(message);
            responseMessage.append("\n");
        });

        return new ResponseEntity<>(responseMessage.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handlerNullPointerException(NullPointerException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IsEmptyException.class)
    public ResponseEntity<String> handlerIsEmptyException(IsEmptyException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
    }
}
