package restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

    @DeleteMapping("/moviepeople/{id_moviepeople}")
    Map<String, Boolean> deleteMoviePeople(@PathVariable Integer id_moviepeople) throws ResourceNotFoundException {
        MoviePeople moviePeople = repository.findOne(id_moviepeople);
        repository.delete(moviePeople);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
