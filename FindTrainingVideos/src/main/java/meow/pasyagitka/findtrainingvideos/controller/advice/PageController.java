package meow.pasyagitka.findtrainingvideos.controller.advice;

import meow.pasyagitka.findtrainingvideos.dto.SearchDto;
import meow.pasyagitka.findtrainingvideos.dto.UserDto;
import meow.pasyagitka.findtrainingvideos.dto.VideoDto;
import meow.pasyagitka.findtrainingvideos.model.User;
import meow.pasyagitka.findtrainingvideos.model.Video;
import meow.pasyagitka.findtrainingvideos.service.VideoService;
import meow.pasyagitka.findtrainingvideos.specification.VideoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
public class PageController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/page")
    public String viewHomePage(Model model) {
        return findPaginatedCriteria(1, "title", "asc", "", "", model);
    }

    /*@GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Video> page = videoService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Video> listEmployees = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("listEmployees", listEmployees);
        return "page";
    }*/

    @GetMapping("/page/{pageNo}")
    public String findPaginatedCriteria(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                        @ModelAttribute("key") String searchKey,
                                        @ModelAttribute("value") String searchValue,
                                Model model) {
        int pageSize = 5;
        VideoSpecification spec = Objects.equals(searchKey, "") ? null :
             new VideoSpecification(new SearchDto(searchKey, ":", searchValue));
        Page<Video> page = videoService.findPaginatedCriteria(pageNo, pageSize, sortField, sortDir, spec);
        List<Video> listEmployees = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("listEmployees", listEmployees);
        return "page";
    }

    /*@GetMapping("/signin")
    public String showSignInForm(@ModelAttribute("user") UserDto user) {
        return "signin";
    }
    @PostMapping("/signin")
    public String postSignIn(@ModelAttribute("user") @Valid UserDto user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "signin";
        return "redirect:/";
    }

    @GetMapping("/adminmain1")
    public String showAdminMain1(@ModelAttribute("newVideo") VideoDto video) {
        return "adminmain1";
    }
*/
    /*@GetMapping(value = {"/admin1"})
    public ModelAndView initAdminMain1() {
        return new ModelAndView("adminmain");
    }*/
/*
    @GetMapping(value = {"/admin1"})
    public String initAdminMain1() {
        return "adminmain";
    }*/
/*


    @GetMapping(value = {"/usermain"})
    public String initUserMain() {
        return "usermain";
    }*/

}
