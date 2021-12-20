package meow.pasyagitka.findtrainingvideos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigateController {

    @GetMapping("/login")
    public ModelAndView openLogin() {
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView openRegister() {
        return new ModelAndView("register");
    }
}
