package restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restservice.entity.Genre;
import restservice.repository.GenreRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/genre/{id_genre}")
    Genre one(@PathVariable Integer id_genre) {
        return repository.findOne(id_genre);
    }


    @PutMapping("/genre/{id_genre}")
    ResponseEntity<Genre> update(@PathVariable Integer id_genre, @RequestBody Genre genreDetail) throws
            ResourceNotFoundException {
        Genre genre = repository.findOne(id_genre);



        final Genre updatedGenre = repository.save(genre);
        return ResponseEntity.ok(updatedGenre);
    }

    @DeleteMapping("/genre/{id_genre}")
    Map<String, Boolean> deleteGenre(@PathVariable Integer id_genre) throws  ResourceNotFoundException {
        Genre genre = repository.findOne(id_genre);
        repository.delete(genre);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
