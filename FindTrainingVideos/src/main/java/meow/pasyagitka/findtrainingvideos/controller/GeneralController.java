package meow.pasyagitka.findtrainingvideos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import meow.pasyagitka.findtrainingvideos.dto.DisciplineDto;
import meow.pasyagitka.findtrainingvideos.dto.VideoDto;
import meow.pasyagitka.findtrainingvideos.exceptions.CannotGetDataException;
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

    @Operation(summary = "Get all disciplines")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Disciplines list is present", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Error while displaying discipline list", content = @Content)})
    @GetMapping("/getDisciplines")
    ResponseEntity<List<DisciplineDto>> all() throws CannotGetDataException {
         try {
             return new ResponseEntity<>(disciplineService.listAll(), HttpStatus.OK);
         } catch (Exception e) {
             throw new CannotGetDataException("getDisciplines: ");
         }
    }

    @Operation(summary = "Get current user`s name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Username is present", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Error while getting current user`s name", content = @Content)})
    @GetMapping(value = {"/getUsername"})
    public ResponseEntity<String> getUsername() throws CannotGetDataException{
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!(authentication instanceof AnonymousAuthenticationToken)) {
                String currentUserName = authentication.getName();
                return new ResponseEntity<>(currentUserName, HttpStatus.OK);
            }
            throw new CannotGetDataException("getUsername: ");
        } catch (Exception e) {
           throw e;
        }
    }

    @Operation(summary = "Gets list of all authors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authors list is present", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class))}),
            @ApiResponse(responseCode = "400", description = "Error while returning authors list", content = @Content)})
    @GetMapping(value = {"/getAuthors"})
    public ResponseEntity<List<String>> getAuthors() throws CannotGetDataException{
        try {
            return new ResponseEntity<>(videoService.getAuthors(), HttpStatus.OK);
        } catch (Exception e) {
            throw new CannotGetDataException("getAuthors: ");
        }
    }

    @Operation(summary = "Gets list of all themes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Theme list is present", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class))}),
            @ApiResponse(responseCode = "400", description = "Error while returning theme list", content = @Content)})
    @GetMapping(value = {"/getThemes"})
    public ResponseEntity<List<String>> getThemes() throws CannotGetDataException{
        try {
            return new ResponseEntity<>(videoService.getThemes(), HttpStatus.OK);
        } catch (Exception e) {
            throw new CannotGetDataException("getThemes: ");
        }
    }

    @Operation(summary = "Gets list of all videos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Video list is present", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class))}),
            @ApiResponse(responseCode = "400", description = "Error while returning video list", content = @Content)})
    @GetMapping(value = {"/getVideoList"})
    public ResponseEntity<Page<Video>> getVideosPaginated(@RequestParam("page") Optional<Integer> page) throws CannotGetDataException{
        try {
            return new ResponseEntity<>(videoService.findPaginated(page.orElse(0)), HttpStatus.OK);
        } catch (Exception e) {
            throw new CannotGetDataException("getVideos (paginated): ");
        }
    }
}