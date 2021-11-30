package meow.pasyagitka.findtrainingvideos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import meow.pasyagitka.findtrainingvideos.dto.SearchDto;
import meow.pasyagitka.findtrainingvideos.dto.UserDto;
import meow.pasyagitka.findtrainingvideos.dto.VideoDto;
import meow.pasyagitka.findtrainingvideos.repository.VideoRepository;
import meow.pasyagitka.findtrainingvideos.service.UserService;
import meow.pasyagitka.findtrainingvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

//todo search, filter, download(list)
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private VideoService videoService;

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/usermain")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView("adminmain.html");
        modelAndView.addObject("newVideo", new VideoDto());
        return modelAndView;
    }

    /*@Operation(summary = "Gets list of all videos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Video list is present", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class)) }),
            @ApiResponse(responseCode = "500", description = "Error while returning video list", content = @Content)})
    @GetMapping(value = {"/usermain/getVideoList"})
    public ResponseEntity<List<VideoDto>> getVideosByCriteria() {
        try {
            //BaseSearch<VideoDto> baseSearch = new BaseSearch<>(new SearchDto("userName","eq", "user1"));
            //return new ResponseEntity<>(videoRepository.findAll(baseSearch), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    /*@GetMapping(value = {"/usermain"})
    public ModelAndView initUserMain(Model model) {
        ModelAndView mav = new ModelAndView("usermain");
        mav.addObject("videoList", videoService.listAll());
        return mav;
    }*/


  /*  @PostMapping("/signin")
    public String postSignIn(@ModelAttribute("user") @Valid UserDto user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signin";
        }
        return "redirect:/";
    }

    @PostMapping("/signup")
    public String postSignUp(@ModelAttribute("user") @Valid UserDto user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        return "redirect:/";
    }*/

}
