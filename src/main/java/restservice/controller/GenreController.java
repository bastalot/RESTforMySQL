package restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restservice.entity.Genre;
import restservice.repository.GenreRepository;

import java.util.HashMap;
import java.util.List;

@RestController
public class GenreController {

    @Autowired
    private GenreRepository repository;


    @PostMapping("/genre")
    Genre newGenre(@RequestBody Genre newGenre){
        return repository.save(newGenre);
    }

    @GetMapping("genre/all")
    List<Genre> all(){
        return repository.findAll();
    }


}
