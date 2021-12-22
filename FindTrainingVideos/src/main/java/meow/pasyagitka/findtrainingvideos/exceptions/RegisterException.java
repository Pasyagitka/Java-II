package meow.pasyagitka.findtrainingvideos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class RegisterException extends Exception{
    public RegisterException(String path) {
        super(path + ": register error");
    }

}
