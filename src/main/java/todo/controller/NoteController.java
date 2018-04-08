package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todo.model.Note;
import todo.model.NoteRepository;


@Controller
public class NoteController {

    @Autowired
    private NoteRepository noteRepo;

    @GetMapping("/note")
    public String index(Model model) {
        Iterable<Note> noteList = noteRepo.findAll();
        model.addAttribute("noteList", noteList);
        return "result";
    }
}
