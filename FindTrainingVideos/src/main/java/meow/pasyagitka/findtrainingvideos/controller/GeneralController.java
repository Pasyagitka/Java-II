package meow.pasyagitka.findtrainingvideos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import meow.pasyagitka.findtrainingvideos.dto.DisciplineDto;
import meow.pasyagitka.findtrainingvideos.dto.VideoDto;
import meow.pasyagitka.findtrainingvideos.model.Video;
import meow.pasyagitka.findtrainingvideos.service.DisciplineService;
import meow.pasyagitka.findtrainingvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/general")
@RestController
public class GeneralController {
    @Autowired
    private DisciplineService disciplineService;

    @Autowired
    private VideoService videoService;

     @GetMapping("/getDisciplines")
     ResponseEntity<List<DisciplineDto>> all() {
         return new ResponseEntity<>(disciplineService.listAll(), HttpStatus.OK);
     }

    @GetMapping(value = {"/getUsername"})
    public ResponseEntity<String> getUsername() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!(authentication instanceof AnonymousAuthenticationToken)) {
                String currentUserName = authentication.getName();
                return new ResponseEntity<>(currentUserName, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); //todo userName exc
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

    @Operation(summary = "Gets list of all videos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Video list is present", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class))}),
            @ApiResponse(responseCode = "500", description = "Error while returning video list", content = @Content)})
    @GetMapping(value = {"/getVideoList"})
    public ResponseEntity<Page<Video>> getVideosPaginated(@RequestParam("page") Optional<Integer> page) {
        try {
            return new ResponseEntity<>(videoService.findPaginated(page.orElse(0)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}