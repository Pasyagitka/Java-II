package meow.pasyagitka.findtrainingvideos.controller.advice;

import meow.pasyagitka.findtrainingvideos.exceptions.AddVideoException;
import meow.pasyagitka.findtrainingvideos.exceptions.VideoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VideoNotFoundException.class)
    public ResponseEntity<Response> handleUserNotFoundException(VideoNotFoundException e) {
        return new ResponseEntity<>(new Response(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AddVideoException.class)
    public ResponseEntity<Response> handleCannotAddVideoException(AddVideoException e) {
        return new ResponseEntity<>(new Response(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
