package meow.pasyagitka.findtrainingvideos.dto;

import lombok.Data;
import meow.pasyagitka.findtrainingvideos.validator.Password;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegisterRequestDto {

    @NotBlank(message = "Login is mandatory")
    @Size(max=50, message = "Max length of Login field is 50")
    private String login;

    @Password(message = "Password format is not valid: a digit must occur at least once, a lower case letter must occur at least once")
    @Size(max=500, message = "Max length of Password field is 500")
    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Size(max=100, message = "Max length of Email field is 100")
    @Email(message = "Email is not valid")
    private String email;
}
