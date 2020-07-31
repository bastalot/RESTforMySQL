package restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restservice.entity.Movie;
import restservice.repository.MovieRepository;

import java.util.Base64;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @GetMapping("/movie")
    List<Movie> all() {
        return repository.findAll();
    }

    @PostMapping("/movie")
    Movie newMovie(@RequestBody Movie newMovie) {
        return repository.save(newMovie);
    }

    @GetMapping("/movie/{id_movie}")
    Movie one(@PathVariable Integer id_movie) {
        return repository.findOne(id_movie);
    }

   /* @GetMapping("/movie/{id_movie}/poster")
    byte[] poster(@PathVariable Integer id_movie) {
        return repository.findOne(id_movie).getPoster();
    } */

    @GetMapping("/movie/{id_movie}/poster")
    String poster(@PathVariable Integer id_movie) {
        return Base64.getEncoder().encodeToString(repository.findOne(id_movie).getPoster());
    }


}
