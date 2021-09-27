package meow.pasyagitka.trainingvideos.controller;

import lombok.Data;

//import javax.validation.constraints.NotEmpty;

@Data
public class RegistrationRequest {

//    @NotEmpty
    private String login;

//    @NotEmpty
    private String password;
    //todo password confirm validation
}