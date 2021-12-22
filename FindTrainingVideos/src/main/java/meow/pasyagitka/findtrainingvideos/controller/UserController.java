package meow.pasyagitka.findtrainingvideos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import meow.pasyagitka.findtrainingvideos.dto.VideoDto;
import meow.pasyagitka.findtrainingvideos.model.Video;
import meow.pasyagitka.findtrainingvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/usermain")
@RestController
public class UserController {
    @Autowired
    private VideoService videoService;


    @Operation(summary = "Gets list of all videos for download")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Video list is present", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class))}),
            @ApiResponse(responseCode = "500", description = "Error while returning video list", content = @Content)})
    @GetMapping(value = {"/getVideoListDownload"})
    public ResponseEntity<List<VideoDto>> getVideosDownload() {
        try {
            return new ResponseEntity<>(videoService.listAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Operation(summary = "Search videos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Video list is present", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class))}),
            @ApiResponse(responseCode = "500", description = "Error while returning video list", content = @Content)})
    @GetMapping(value = {"/searchVideos/{title}"})
    public ResponseEntity<Page<Video>> searchVideos(
            @RequestParam("page") Optional<Integer> page,
            @Parameter(description = "title of video to be found")
            @PathVariable("title") String title) {
        try {
            return new ResponseEntity<>(videoService.listAllCriteria(page.orElse(0), title), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Search videos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Video list is present", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class))}),
            @ApiResponse(responseCode = "500", description = "Error while returning video list", content = @Content)})
    @GetMapping(value = {"/filterVideos"})
    public ResponseEntity<Page<Video>> filterVideos(
            @RequestParam("page") Optional<Integer> page,
            @Parameter(description = "theme of video to be filtered")
            @RequestParam String theme, @RequestParam String author) {
        try {
            return new ResponseEntity<>(videoService.filterVideos(page.orElse(0), theme, author), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

