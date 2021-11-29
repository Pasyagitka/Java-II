package meow.pasyagitka.findtrainingvideos.controller;

import meow.pasyagitka.findtrainingvideos.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private RoleService service;
}
