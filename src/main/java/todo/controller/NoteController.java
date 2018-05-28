package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import todo.model.Note;
import todo.model.NoteRepository;
import todo.model.User;
import todo.model.UserRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class NoteController {


    @Autowired
    private NoteRepository noteRepo;
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/index")
    public String indexHomePage() {
        return "../static/index";
    }

    @GetMapping("/note")
    public String index(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
            User user = userRepo.findByUsername((String) session.getAttribute("username"));
            Iterable<Note> noteList = noteRepo.findByUserId(user.getUserId());
            model.addAttribute("noteList", noteList);
            return "result";
        } else {
            return "redirect:index";
        }
//        Iterable<Note> noteList = noteRepo.findAll();
//        model.addAttribute("noteList", noteList);
//        return "result";
    }

    @PostMapping("/addnote")
    public String addNote(@RequestParam("task") String task,HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = userRepo.findByUsername((String) session.getAttribute("username"));
        System.out.println(new Timestamp(System.currentTimeMillis()));
        System.out.println(new Date());
        Note note = new Note();
        note.setTask(task);
        note.setUpdateDate(new Date());
        note.setUser(user);
        noteRepo.save(note);
        return "redirect:/note";
    }

    @GetMapping("/register")
    public String registerMember() {
        return "register";
    }

    @PostMapping("/login")
    public String checkUserLogin(@RequestParam("username") String username, @RequestParam("password") String password,
                                 Model model, HttpServletRequest request) {
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        Iterable<User> user = userRepo.getUserByUsername(username, password);
        if (!((List<User>) user).isEmpty()) {
            //set session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            model.addAttribute("userList", user);
            model.addAttribute("session", session.getAttribute("username"));
            return "redirect:/note";
        } else {
            return "redirect:index"; //login page
        }
    }
//
//    public static boolean checkUserIsLogin(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        if (session.getAttribute("username") != null) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
