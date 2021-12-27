package meow.pasyagitka.findtrainingvideos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EditVideoException extends Exception {

    public EditVideoException(String path) {
        super(path + ": error while editing a video");
    }
}
