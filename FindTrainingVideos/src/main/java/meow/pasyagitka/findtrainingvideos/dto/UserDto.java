package meow.pasyagitka.findtrainingvideos.dto;

import lombok.Data;
import meow.pasyagitka.findtrainingvideos.model.Role;
import meow.pasyagitka.findtrainingvideos.validator.Password;

import javax.validation.constraints.Size;

@Data
public class UserDto {
    private Integer id;

    @Size(min=2, max=50, message = "Login must contain from 2 to 50 characters")
    private String login;

    @Password(message = "{valid.password.password}")
    private String password;

    private Role roleEntity;
}
