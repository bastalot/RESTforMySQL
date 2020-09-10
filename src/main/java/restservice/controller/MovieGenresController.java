package restservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import restservice.entity.Genre;
import restservice.entity.Movie;
import restservice.entity.MovieGenres;
import restservice.repository.MovieGenresRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MovieGenresController {

    @Autowired
    private MovieGenresRepository repository;

    @PostMapping("/moviegenres")
    MovieGenres newMovieGenres(@RequestBody MovieGenres newMovieGenres) {
        return repository.save(newMovieGenres);
    }

    @GetMapping("/moviegenres/all")
    List<MovieGenres> all() {
        return repository.findAll();
    }

    @DeleteMapping("/moviegenres/{id_moviegenres}")
    Map<String, Boolean> deleteMovieGenres(@PathVariable Integer id_moviegenres) throws ResourceNotFoundException {
        MovieGenres movieGenres = repository.findOne(id_moviegenres);
        repository.delete(movieGenres);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
