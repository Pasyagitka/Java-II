package meow.pasyagitka.findtrainingvideos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AddVideoException extends Exception{

    public AddVideoException(String path) {
        super(path + ": error while adding new video");
    }
}
