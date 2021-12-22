package meow.pasyagitka.findtrainingvideos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(String path) {
        super(path + ": user already exists");
    }
}
