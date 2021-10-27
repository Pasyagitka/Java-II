package meow.pasyagitka.findtrainingvideos.controller;

import meow.pasyagitka.findtrainingvideos.model.Video;
import meow.pasyagitka.findtrainingvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VideoController {
    @Autowired
    private VideoService service;

    @GetMapping(value = {"/adminmain"})
    public ModelAndView adminMain(Model model) {
        List<Video> videoList = service.listAll();
        ModelAndView mav = new ModelAndView("adminmain");
        mav.addObject("videoList", videoList);
        return mav;
    }
}