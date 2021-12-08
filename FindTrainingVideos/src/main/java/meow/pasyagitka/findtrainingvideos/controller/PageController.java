package meow.pasyagitka.findtrainingvideos.controller;

import meow.pasyagitka.findtrainingvideos.dto.SearchDto;
import meow.pasyagitka.findtrainingvideos.model.Video;
import meow.pasyagitka.findtrainingvideos.service.VideoService;
import meow.pasyagitka.findtrainingvideos.specification.VideoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
}
