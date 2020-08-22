package restservice.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import restservice.entity.Genre;
import restservice.entity.Movie;
import restservice.entity.MovieGenres;
import restservice.repository.MovieGenresRepository;

import java.util.List;

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

}
