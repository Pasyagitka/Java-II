package meow.pasyagitka.findtrainingvideos.controller;

import meow.pasyagitka.findtrainingvideos.model.Discipline;
import meow.pasyagitka.findtrainingvideos.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DisciplineController {
    @Autowired
    private DisciplineService service;

    @GetMapping(value = {"/disciplines"})
    public ModelAndView adminMain(Model model) {
        List<Discipline> list = service.listAll();
        ModelAndView mav = new ModelAndView("disciplines");
        mav.addObject("disciplineList", list);
        return mav;
    }
}