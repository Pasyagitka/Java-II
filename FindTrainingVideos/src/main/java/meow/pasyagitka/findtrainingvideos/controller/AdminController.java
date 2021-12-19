package meow.pasyagitka.findtrainingvideos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import meow.pasyagitka.findtrainingvideos.dto.AddVideoDto;
import meow.pasyagitka.findtrainingvideos.dto.VideoDto;
import meow.pasyagitka.findtrainingvideos.exceptions.AddVideoException;
import meow.pasyagitka.findtrainingvideos.exceptions.DeleteVideoException;
import meow.pasyagitka.findtrainingvideos.exceptions.EditVideoException;
import meow.pasyagitka.findtrainingvideos.exceptions.VideoNotFoundException;
import meow.pasyagitka.findtrainingvideos.service.DisciplineService;
import meow.pasyagitka.findtrainingvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/adminmain")
@RestController
public class AdminController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private DisciplineService disciplineService;
    /*@GetMapping("/adminmain/editvideo/{id}")
    public ModelAndView openedit(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("editvideo.html");
        modelAndView.addObject("video", videoService.get(id));
        return modelAndView;
    }*/

    @Operation(summary = "Gets list of all videos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Video list is present", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class)) }),
            @ApiResponse(responseCode = "500", description = "Error while returning video list", content = @Content)})
    @GetMapping(value = {"/getVideoList"})
    public ResponseEntity<List<VideoDto>> getVideos() {
        try {
            return new ResponseEntity<>(videoService.listAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Adds a new video")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "New video is created", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class)) }),
            @ApiResponse(responseCode = "500", description = "Error while creating a new video", content = @Content)})
    @PostMapping("/addvideo")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VideoDto> saveVideo(
            @Parameter(description = "New video object")
            @Valid @RequestBody AddVideoDto addVideoDto) throws AddVideoException { //todo VideoDto
        try {
            VideoDto newVideo = new VideoDto();
            newVideo.setTitle(addVideoDto.getTitle());
            newVideo.setTheme(addVideoDto.getTheme());
            newVideo.setDisciplineEntity(disciplineService.get(addVideoDto.getDisciplineId()));
            newVideo.setAuthor(addVideoDto.getAuthor());
            newVideo.setUrl(addVideoDto.getUrl());
            newVideo.setDescription(addVideoDto.getDescription());
            VideoDto v = videoService.save(newVideo);
            return new ResponseEntity<>(v, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new AddVideoException("/adminmain/addvideo");
        }
    }

    @Operation(summary = "Updates a video by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The video is edited", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Video not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error while editing a video", content = @Content)})
    @PutMapping(value = "/editvideo/{id}")
    public ResponseEntity<VideoDto> updateVideo(
            @PathVariable("id") int id,
            @RequestBody @Valid AddVideoDto newVideoData) throws EditVideoException {
        try {
            VideoDto videoData = videoService.get(id);

            if (videoData != null) {
                videoData.setTitle(newVideoData.getTitle());
                videoData.setTheme(newVideoData.getTheme());
                videoData.setDisciplineEntity(disciplineService.get(newVideoData.getDisciplineId()));
                videoData.setAuthor(newVideoData.getAuthor());
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

    @Operation(summary = "Deletes a video by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Video is deleted", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class)) }),
            @ApiResponse(responseCode = "500", description = "Error while deleting a video", content = @Content)})
    @DeleteMapping("/deletevideo/{id}")
    public ResponseEntity<HttpStatus> deleteVideo(@Parameter(description = "id of video to be deleted") @PathVariable("id") int id) throws DeleteVideoException {
        try {
            videoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new DeleteVideoException("/adminmain/deletevideo/{id}");
        }
    }
}
