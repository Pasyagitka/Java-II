package meow.pasyagitka.findtrainingvideos.controller;

import meow.pasyagitka.findtrainingvideos.dto.DisciplineDto;
import meow.pasyagitka.findtrainingvideos.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/adminmain")
@RestController
public class DisciplineController {
    @Autowired
    private DisciplineService service;

     @GetMapping("/getDisciplines")
     ResponseEntity<List<DisciplineDto>> all() {
         return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
     }

}