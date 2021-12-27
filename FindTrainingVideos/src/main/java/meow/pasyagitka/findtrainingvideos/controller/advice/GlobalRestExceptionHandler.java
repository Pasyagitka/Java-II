package meow.pasyagitka.findtrainingvideos.controller.advice;

import meow.pasyagitka.findtrainingvideos.exceptions.*;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.print.attribute.standard.JobKOctets;
import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleCannotAddVideoException(UserNotFoundException e) {
        return new ResponseEntity<>(createExceptionError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VideoNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleUserNotFoundException(VideoNotFoundException e) {
        return new ResponseEntity<>(createExceptionError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddVideoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleCannotAddVideoException(AddVideoException e) {
        return new ResponseEntity<>(createExceptionError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EditVideoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleCannotEditVideoException(EditVideoException e) {
        return new ResponseEntity<>(createExceptionError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DeleteVideoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleCannotDeleteVideoException(DeleteVideoException e) {
        return new ResponseEntity<>(createExceptionError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RegisterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleCannotCreateAccountException(RegisterException e) {
        return new ResponseEntity<>(createExceptionError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return new ResponseEntity<>(createExceptionError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    public Map<String, Object> createExceptionError(String message){
        Map<String, Object> body = new LinkedHashMap<>();
        List<String> errors = new ArrayList<>();
        errors.add(message);
        body.put("errors", errors);
        return body;
    }
}
