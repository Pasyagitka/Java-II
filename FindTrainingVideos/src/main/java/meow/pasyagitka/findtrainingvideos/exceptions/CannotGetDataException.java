package meow.pasyagitka.findtrainingvideos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CannotGetDataException extends  Exception{
    public CannotGetDataException(String message)
    {
        super(message + ": data not found");
    }
}
