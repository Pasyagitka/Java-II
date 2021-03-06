package meow.pasyagitka.findtrainingvideos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class DeleteVideoException extends Exception {

    public DeleteVideoException(String path) {
        super(path + ": error while deleting a video");
    }
}
