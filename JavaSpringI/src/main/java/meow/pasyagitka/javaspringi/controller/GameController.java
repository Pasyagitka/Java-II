package meow.pasyagitka.javaspringi.controller;

import lombok.extern.slf4j.Slf4j;
import meow.pasyagitka.javaspringi.forms.GameForm;
import meow.pasyagitka.javaspringi.model.Game;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class GameController {
    static int gameid = 0;

    private static List<Game> games = new ArrayList<>();
    static {
        games.add(new Game(++gameid, "Full Stack Development with JHipster", "Deepu K Sasidharan, Sendil Kumar N"));
        games.add(new Game(++gameid, "Pro Spring Security", "Carlo Scarioni, Massimo Nardone"));
        games.add(new Game(++gameid, "Game22323", "Karl"));
        games.add(new Game(++gameid, "Game645644", "Melissa"));
        games.add(new Game(++gameid, "Game23203290", "Fenik"));
    }
    //
    // Вводится (inject) из application.properties.
    @Value("${welcome.message}")
    private String message;
    @Value("${error.message}")
    private String errorMessage;

    @GetMapping(value = {"/", "/index"})
    public ModelAndView index(Model model) {
        model.addAttribute("message", message);
        log.info("/index was called");
        return new ModelAndView("index");
    }
    @GetMapping(value = {"/allgames"})
    public ModelAndView gameList(Model model) {
        model.addAttribute("games", games);
        log.info("/allgames was called");
        return new ModelAndView("gamelist");
    }

    @GetMapping(value = {"/addgame"})
    public ModelAndView showAddGamePage(Model model) {
        GameForm gameForm = new GameForm();
        model.addAttribute("gameform", gameForm);
        log.info("/addgame was called");
        return new ModelAndView("addgame");
    }

    @PostMapping(value = {"/addgame"})
    public ModelAndView saveGame(Model model, @ModelAttribute("gameform") GameForm gameForm) {
        String title = gameForm.getTitle();
        String author = gameForm.getAuthor();
        if (title != null && title.length() > 0 && author != null && author.length() > 0) {
            Game newGame = new Game(++gameid, title, author);
            games.add(newGame);
            model.addAttribute("games", games);
            return new ModelAndView("gamelist");
        }
        log.info("Add game...");
        model.addAttribute("errorMessage", errorMessage);
        return new ModelAndView("gamelist");
    }

    @GetMapping("/editgame")
    public ModelAndView showEditGamePage(Model model, @RequestParam int id) {
        Optional<Game> optionalGame = games.stream().filter(a -> a.getId() == id).findFirst();
        if (optionalGame.isPresent()) {
            Game gameToEdit = optionalGame.get();
            model.addAttribute("id", gameToEdit.getId());
            model.addAttribute("gameform", new GameForm(gameToEdit.getTitle(), gameToEdit.getAuthor()));
            log.info("Editing game page opens...");
        }
        return new ModelAndView("editgame");
    }

    @PostMapping("/editgame")
    public ModelAndView saveEditedPerson(Model model, @ModelAttribute("gameform") GameForm gameForm, @RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("editgame");
        String newTitle = gameForm.getTitle();
        String newAuthor = gameForm.getAuthor();

        if (newTitle != null && newTitle.length() > 0 && newAuthor != null && newAuthor.length() > 0) {
            Optional<Game> optionalGame = games.stream().filter(a -> a.getId() == id).findFirst();
            if (optionalGame.isPresent()) {
                Game gameToEdit = optionalGame.get();
                gameToEdit.setTitle(newTitle);
                gameToEdit.setAuthor(newAuthor);
            }
            model.addAttribute("games", games);
            log.info("Edit game #" + id);
            modelAndView.setViewName("gamelist");
            return modelAndView;
        }
        model.addAttribute("errorMessage", errorMessage);
        return modelAndView;
    }

    @GetMapping("/deletegame")
    public ModelAndView deleteGame(Model model, @RequestParam int id) {
        games.removeIf(x -> x.getId() == id);
        model.addAttribute("games", games);
        log.info("Delete game #" + id);
        return new ModelAndView("gamelist");
    }
}