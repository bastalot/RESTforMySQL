package restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restservice.entity.Movie;
import restservice.repository.MovieRepository;

import javax.validation.Valid;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PutMapping("/movie/{id_movie}")
    ResponseEntity<Movie> update(@PathVariable Integer id_movie, @RequestBody Movie movieDetails) throws ResourceNotFoundException {
        Movie movie = repository.findOne(id_movie);

        if (movieDetails.getTitle() != null)
            movie.setTitle(movieDetails.getTitle());
        if (movieDetails.getRelease_date() != null)
        movie.setRelease_date(movieDetails.getRelease_date());
        if (movieDetails.getRuntime() != null)
        movie.setRuntime(movieDetails.getRuntime());
        if (movieDetails.getSummary() != null)
        movie.setSummary(movieDetails.getSummary());
        if (movieDetails.getPoster() != null){
            movie.setPoster(movieDetails.getPoster());
        }


        final Movie updatedmovie = repository.save(movie);
        return ResponseEntity.ok(updatedmovie);

    }

    @DeleteMapping("/movie/{id_movie}")
    Map<String, Boolean> deleteMovie(@PathVariable Integer id_movie) throws ResourceNotFoundException {
       Movie movie = repository.findOne(id_movie);
       repository.delete(movie);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;

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
