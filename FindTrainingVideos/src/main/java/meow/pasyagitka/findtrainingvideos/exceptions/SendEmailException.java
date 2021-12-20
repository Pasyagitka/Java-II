package meow.pasyagitka.findtrainingvideos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class SendEmailException extends Exception {

    public SendEmailException(String path) {
        super(path + ": error while sending the email");
    }
}
