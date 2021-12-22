package meow.pasyagitka.findtrainingvideos.dto;

import lombok.Data;
import meow.pasyagitka.findtrainingvideos.validator.Password;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginRequestDto {
    @NotBlank(message = "Login is mandatory")
    private String login;

    @NotBlank(message = "Password is mandatory")
    private String password;
}
