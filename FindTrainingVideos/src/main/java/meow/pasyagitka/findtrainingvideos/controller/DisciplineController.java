package meow.pasyagitka.findtrainingvideos.controller;

import meow.pasyagitka.findtrainingvideos.dto.DisciplineDto;
import meow.pasyagitka.findtrainingvideos.model.Discipline;
import meow.pasyagitka.findtrainingvideos.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class DisciplineController {
    @Autowired
    private DisciplineService service;

    /*   @GetMapping(value = {"/disciplines"})
    public ModelAndView getAllDisciplines(Model model) {
        List<DisciplineDto> list = service.listAll();
        ModelAndView mav = new ModelAndView("disciplines");
        mav.addObject("disciplineList", list);
        return mav;
    }*/

     @GetMapping("/disciplines")
     ResponseEntity<List<DisciplineDto>> all() {
         return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
     }

}