package todo.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.model.User;
import todo.model.UserDAO;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @PostMapping("/checkLogin")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
    public List<User> updateCustomer(@RequestBody String jsonString) throws JSONException {
        // Creating a JSONObject from a String
        JSONObject nodeRoot = new JSONObject(jsonString);
        String username = nodeRoot.getString("username");
        String password = nodeRoot.getString("password");
        List<User> customerList = userDAO.findByUsername(username);
        return customerList;
    }
    @RequestMapping(value="/checkLogin2", method=RequestMethod.POST)
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000","http://localhost:8090"})
    public ResponseEntity<Iterable<User>> getDepartments(@RequestBody String jsonString) throws JSONException  {
        JSONObject nodeRoot = new JSONObject(jsonString);
        String username = nodeRoot.getString("username");
        String password = nodeRoot.getString("password");
        List<User> depts = userDAO.findByUsername(username);
      //  List<User> depts = userDAO.findByUsername("vara.phon");
        return new ResponseEntity<>(depts, HttpStatus.OK);
    }
    @RequestMapping(value="/checkLogin4", method=RequestMethod.GET)
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000","http://localhost:8090"})
    public ResponseEntity<Iterable<User>> getDepartments(){
          List<User> depts = userDAO.findByUsername("vara.phon");
        return new ResponseEntity<>(depts, HttpStatus.OK);
    }
}