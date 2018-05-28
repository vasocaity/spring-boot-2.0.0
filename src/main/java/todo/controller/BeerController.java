package todo.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.model.Beer;
import todo.model.BeerRepository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BeerController {
    private BeerRepository repository;

    public BeerController(BeerRepository repository) {
        this.repository = repository;
    }

//    @GetMapping("/good-beers")
//    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
//    public Collection<Beer> goodBeers() {
//        return repository.findAll().stream()
//                .filter(this::isGreat)
//                .collect(Collectors.toList());
//    }
    private boolean isGreat(Beer beer) {
        return !beer.getName().equals("Budweiser") &&
                !beer.getName().equals("Coors Light") &&
                !beer.getName().equals("PBR");
    }
}