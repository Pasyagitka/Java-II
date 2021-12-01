package meow.pasyagitka.findtrainingvideos.controller;

import meow.pasyagitka.findtrainingvideos.repository.VideoRepository;
import meow.pasyagitka.findtrainingvideos.service.UserService;
import meow.pasyagitka.findtrainingvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//todo search, filter, download(list)
@Controller
public class UserController {

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


  /*  @PostMapping("/login")
    public String postlogin(@ModelAttribute("user") @Valid UserDto user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
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
