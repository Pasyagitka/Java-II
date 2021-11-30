package meow.pasyagitka.findtrainingvideos.controller;

import meow.pasyagitka.findtrainingvideos.dto.UserDto;
import meow.pasyagitka.findtrainingvideos.model.User;
import meow.pasyagitka.findtrainingvideos.security.JwtProvider;
import meow.pasyagitka.findtrainingvideos.service.RoleService;
import meow.pasyagitka.findtrainingvideos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("/adminmain")
    public String getAdmin() {
        return "Hi admin";
    }

    @GetMapping("/usermain")
    public String getUser() {
        return "Hi user";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User registrationRequest) {
        User u = new User();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        userService.saveUser(u);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> auth(@RequestBody User user) {
        UserDto userEntity = userService.findByLoginAndPassword(user.getLogin(), user.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
