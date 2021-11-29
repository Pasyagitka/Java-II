package meow.pasyagitka.findtrainingvideos.controller;

import meow.pasyagitka.findtrainingvideos.dto.VideoDto;
import meow.pasyagitka.findtrainingvideos.exceptions.AddVideoException;
import meow.pasyagitka.findtrainingvideos.exceptions.DeleteVideoException;
import meow.pasyagitka.findtrainingvideos.exceptions.EditVideoException;
import meow.pasyagitka.findtrainingvideos.exceptions.VideoNotFoundException;
import meow.pasyagitka.findtrainingvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private VideoService videoService;

    @GetMapping(value = {"/admin"})
    public ModelAndView initAdminMain(Model model) {
        ModelAndView mav = new ModelAndView("adminmain");
        mav.addObject("videoList", videoService.listAll());
        mav.addObject("newVideo", new VideoDto());
        return mav;
    }

    @GetMapping(value = {"/adminmain"})
    public ResponseEntity<List<VideoDto>> getVideos() {
        try {
            videoService.listAll();
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //todo dto for new video (no date,...)
    @PostMapping("/adminmain/addvideo")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VideoDto> saveVideo(@Valid @RequestBody VideoDto videoDto) throws AddVideoException {
        try {
            VideoDto v = videoService.save(videoDto);
            return new ResponseEntity<>(v, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new AddVideoException("/adminmain/addvideo");
        }
    }

    @PutMapping("/adminmain/editvideo/{id}")
    public ResponseEntity<VideoDto> updateVideo(@PathVariable("id") int id, @RequestBody VideoDto newVideoData) throws EditVideoException {
        try {
            VideoDto videoData = videoService.get(id);

            if (videoData != null) {
                videoData.setTitle(newVideoData.getTitle());
                videoData.setTheme(newVideoData.getTheme());
                videoData.setDisciplineEntity(newVideoData.getDisciplineEntity());
                videoData.setAuthor(newVideoData.getAuthor());
                videoData.setDate(newVideoData.getDate());
                videoData.setUrl(newVideoData.getUrl());
                videoData.setDescription(newVideoData.getDescription());
                return new ResponseEntity<>(videoService.save(videoData), HttpStatus.OK);
            }
            throw new VideoNotFoundException("/adminmain/editvideo/{id}");
        }
        catch (Exception e) {
            throw new EditVideoException("/adminmain/editvideo/{id}");
        }
    }

    @DeleteMapping("/adminmain/deletevideo/{id}")
    public ResponseEntity<HttpStatus> deleteVideo(@PathVariable("id") int id) throws DeleteVideoException {
        try {
            videoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new DeleteVideoException("/adminmain/deletevideo/{id}");
        }
    }
}
