package meow.pasyagitka.findtrainingvideos.dto;

import lombok.Data;
import meow.pasyagitka.findtrainingvideos.validator.Password;

@Data
public class UserAuthDto {
    private String login;
    private String password;
}
