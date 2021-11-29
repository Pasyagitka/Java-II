package meow.pasyagitka.findtrainingvideos.controller;

import meow.pasyagitka.findtrainingvideos.dto.UserDto;
import meow.pasyagitka.findtrainingvideos.service.UserService;
import meow.pasyagitka.findtrainingvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

//todo search, filter, download(list)
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private VideoService videoService;

    @GetMapping("/signin")
    public String getSignIn(@ModelAttribute("user") UserDto user) {
        return "signin";
    }

    @GetMapping("/signup")
    public String getSignUp(@ModelAttribute("user") UserDto user) {
        return "signup";
    }

    @GetMapping(value = {"/usermain"})
    public ModelAndView initUserMain(Model model) {
        ModelAndView mav = new ModelAndView("usermain");
        mav.addObject("videoList", videoService.listAll());
        return mav;
    }


    @PostMapping("/signin")
    public String postSignIn(@ModelAttribute("user") @Valid UserDto user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signin";
        }
        return "redirect:/";
    }

    @PostMapping("/signup")
    public String postSignUp(@ModelAttribute("user") @Valid UserDto user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        return "redirect:/";
    }

}
