package meow.pasyagitka.trainingvideos.controller;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}