package meow.pasyagitka.findtrainingvideos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import meow.pasyagitka.findtrainingvideos.dto.VideoDto;
import meow.pasyagitka.findtrainingvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private VideoService videoService;

    @Operation(summary = "Gets list of all videos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Video list is present", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class))}),
            @ApiResponse(responseCode = "500", description = "Error while returning video list", content = @Content)})
    @GetMapping(value = {"/usermain/getVideoList"})
    public ResponseEntity<List<VideoDto>> getVideos() {
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
    @GetMapping(value = {"/usermain/searchVideos/{title}"})
    public ResponseEntity<List<VideoDto>> searchVideos(
            @Parameter(description = "title of video to be found")
            @PathVariable("title") String title) {
        try {
            //BaseSearch<VideoDto> baseSearch = new BaseSearch<>(new SearchDto("userName","eq", "user1"));
            return new ResponseEntity<>(videoService.listAllCriteria(title), HttpStatus.OK);
            //return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Search videos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Video list is present", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class))}),
            @ApiResponse(responseCode = "500", description = "Error while returning video list", content = @Content)})
    @GetMapping(value = {"/usermain/filterVideos"})
    public ResponseEntity<List<VideoDto>> filterVideos(
            @Parameter(description = "theme of video to be filtered")
            @RequestParam String theme, @RequestParam String author) {
        try {
            return new ResponseEntity<>(videoService.filterVideos(theme, author), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Gets list of all authors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authors list is present", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class))}),
            @ApiResponse(responseCode = "500", description = "Error while returning authors list", content = @Content)})
    @GetMapping(value = {"/getAuthors"})
    public ResponseEntity<List<String>> getAuthors() {
        try {
            return new ResponseEntity<>(videoService.getAuthors(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Gets list of all themes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Theme list is present", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class))}),
            @ApiResponse(responseCode = "500", description = "Error while returning theme list", content = @Content)})
    @GetMapping(value = {"/getThemes"})
    public ResponseEntity<List<String>> getThemes() {
        try {
            return new ResponseEntity<>(videoService.getThemes(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

