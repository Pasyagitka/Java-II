package meow.pasyagitka.findtrainingvideos.controller;

import meow.pasyagitka.findtrainingvideos.dto.UserDto;
import meow.pasyagitka.findtrainingvideos.dto.VideoDto;
import meow.pasyagitka.findtrainingvideos.exceptions.DeleteVideoException;
import meow.pasyagitka.findtrainingvideos.exceptions.UserNotFoundException;
import meow.pasyagitka.findtrainingvideos.model.User;
import meow.pasyagitka.findtrainingvideos.security.JwtProvider;
import meow.pasyagitka.findtrainingvideos.service.RoleService;
import meow.pasyagitka.findtrainingvideos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("/adminmain")
    public ModelAndView welcomeAdmin() {
        ModelAndView modelAndView = new ModelAndView("adminmain.html");
        modelAndView.addObject("newVideo", new VideoDto());
        return modelAndView;
    }

    @GetMapping("/usermain")
    public ModelAndView welcomeUser() {
        ModelAndView modelAndView = new ModelAndView("page.html");
        modelAndView.addObject("newVideo", new VideoDto());
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView openRegister() {
        ModelAndView modelAndView = new ModelAndView("signup.html");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid UserDto registrationRequest) {
        User u = new User();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        userService.saveUser(u);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/login")
    public ModelAndView openLogin() {
        ModelAndView modelAndView = new ModelAndView("login.html");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }

    @PostMapping("/login")
    public ResponseEntity<String> auth(UserDto user) throws UserNotFoundException {
        try {
            UserDto userEntity = userService.findByLoginAndPassword(user.getLogin(), user.getPassword());
            String token = jwtProvider.generateToken(userEntity.getLogin());
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        catch (Exception e){
            throw new UserNotFoundException("/login");
        }
    }

}
