package meow.pasyagitka.findtrainingvideos.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigateController {

    @Operation(summary = "Navigate to login page")
    @GetMapping("/login")
    public ModelAndView openLogin() {
        return new ModelAndView("login");
    }

    @Operation(summary = "Navigate to register page")
    @GetMapping("/register")
    public ModelAndView openRegister() {
        return new ModelAndView("register");
    }

    @Operation(summary = "Navigate to admin`s main page")
    @GetMapping("/adminmain")
    public ModelAndView openAdminMain() {
        return new ModelAndView("adminmain");
    }

    @Operation(summary = "Navigate to user`s main page")
    @GetMapping("/usermain")
    public ModelAndView openUserMain() {
        return new ModelAndView("usermain");
    }
}
