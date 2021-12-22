package meow.pasyagitka.findtrainingvideos.controller;

import meow.pasyagitka.findtrainingvideos.dto.*;
import meow.pasyagitka.findtrainingvideos.exceptions.DeleteVideoException;
import meow.pasyagitka.findtrainingvideos.exceptions.RegisterException;
import meow.pasyagitka.findtrainingvideos.exceptions.UserAlreadyExistsException;
import meow.pasyagitka.findtrainingvideos.exceptions.UserNotFoundException;
import meow.pasyagitka.findtrainingvideos.model.User;
import meow.pasyagitka.findtrainingvideos.security.JwtProvider;
import meow.pasyagitka.findtrainingvideos.service.RoleService;
import meow.pasyagitka.findtrainingvideos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {
    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;


    @PostMapping(value="/login", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> auth(@RequestBody @Valid LoginRequestDto loginRequest) throws UserNotFoundException {
        try {
            UserDto userEntity = userService.findByLoginAndPassword(loginRequest.getLogin(), loginRequest.getPassword());
            String token = jwtProvider.generateToken(userEntity.getLogin());
            HttpHeaders headers = new HttpHeaders();
            headers.add(AUTHORIZATION, "Bearer " + token);
            return new ResponseEntity<>(userEntity.getRoleEntity().getName(), headers, HttpStatus.OK);
        }
        catch (Exception e){
            throw new UserNotFoundException("/login: user not found");
        }
    }

    @PostMapping(value="/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterRequestDto registrationRequest) throws UserAlreadyExistsException, RegisterException {
       try {
           if (null != userService.getByLogin(registrationRequest.getLogin()))
               throw new UserAlreadyExistsException("/register: login is already taken");
           User u = new User();
           u.setPassword(registrationRequest.getPassword());
           u.setLogin(registrationRequest.getLogin());
           u.setEmail(registrationRequest.getEmail());
           userService.saveUser(u);
           return new ResponseEntity<>("OK", HttpStatus.OK);
       }
       catch (UserAlreadyExistsException e) {
           throw e;
       }
       catch (Exception e) {
            throw new RegisterException("Error while creating an account");
       }
    }

}
