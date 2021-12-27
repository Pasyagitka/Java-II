package meow.pasyagitka.findtrainingvideos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import meow.pasyagitka.findtrainingvideos.dto.LoginRequestDto;
import meow.pasyagitka.findtrainingvideos.dto.RegisterRequestDto;
import meow.pasyagitka.findtrainingvideos.dto.UserDto;
import meow.pasyagitka.findtrainingvideos.exceptions.RegisterException;
import meow.pasyagitka.findtrainingvideos.exceptions.UserAlreadyExistsException;
import meow.pasyagitka.findtrainingvideos.exceptions.UserNotFoundException;
import meow.pasyagitka.findtrainingvideos.model.User;
import meow.pasyagitka.findtrainingvideos.security.JwtProvider;
import meow.pasyagitka.findtrainingvideos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;


    @Operation(summary = "Login user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful login", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = LoginRequestDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Error while logging in", content = @Content)})
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

    @Operation(summary = "Register new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful register", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = RegisterRequestDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Error while creating a new user", content = @Content)})
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
