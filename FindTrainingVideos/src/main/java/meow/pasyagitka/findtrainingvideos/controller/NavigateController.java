package meow.pasyagitka.findtrainingvideos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigateController {

    @GetMapping("/login")
    public ModelAndView openLogin() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView openRegister() {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }
}
