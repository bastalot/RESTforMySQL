package restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restservice.entity.MoviePeople;
import restservice.repository.MoviePeopleRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MoviePeopleController {

    @Autowired
    private MoviePeopleRepository repository;

    @PostMapping("/moviepeople")
    MoviePeople newMoviePeople(@RequestBody MoviePeople newMoviePeople) {
        return repository.save(newMoviePeople);
    }

    @GetMapping("/moviepeople/all")
    List<MoviePeople> all() {
        return repository.findAll();
    }

    @GetMapping("/moviepeople/{id_moviepeople}")
    MoviePeople one(@PathVariable Integer id_moviepeople) {
        return repository.findOne(id_moviepeople);
    }

    @DeleteMapping("/moviepeople/{id_moviepeople}")
    Map<String, Boolean> deleteMoviePeople(@PathVariable Integer id_moviepeople) throws ResourceNotFoundException {
        MoviePeople moviePeople = repository.findOne(id_moviepeople);
        repository.delete(moviePeople);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/moviepeople/{id_moviepeople}")
    ResponseEntity<MoviePeople> update(@PathVariable Integer id_moviepeople, @RequestBody MoviePeople moviepeopleDetails) throws
            ResourceNotFoundException {
        MoviePeople moviePeople = repository.findOne(id_moviepeople);

        if (moviepeopleDetails.getId_movie() != null && !(moviepeopleDetails.getId_movie().equals(moviePeople.getId_movie()))) {
            moviePeople.setId_movie(moviepeopleDetails.getId_movie());
        }
        if (moviepeopleDetails.getId_person() != null && !(moviepeopleDetails.getId_person().equals(moviePeople.getId_person()))) {
            moviePeople.setId_person(moviepeopleDetails.getId_person());
        }
        if (moviepeopleDetails.getCharacter_name() != null && !(moviepeopleDetails.getCharacter_name().equals(moviePeople.getCharacter_name()))) {
            moviePeople.setCharacter_name(moviepeopleDetails.getCharacter_name());
        }

        final MoviePeople updatedmoviepeople = repository.save(moviePeople);
        return ResponseEntity.ok(updatedmoviepeople);
    }

}
