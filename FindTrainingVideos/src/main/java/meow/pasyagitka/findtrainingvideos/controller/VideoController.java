package meow.pasyagitka.findtrainingvideos.controller;

import meow.pasyagitka.findtrainingvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {
    @Autowired
    private VideoService videoService;

}