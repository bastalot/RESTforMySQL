package restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restservice.entity.SeriesPeople;
import restservice.repository.SeriesPeopleRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SeriesPeopleController {

    @Autowired
    private SeriesPeopleRepository repository;

    @PostMapping("/seriespeople")
    SeriesPeople newSeriesPeople(@RequestBody SeriesPeople newSeriesPeople) {
        return repository.save(newSeriesPeople);
    }

    @GetMapping("/seriespeople/all")
    List<SeriesPeople> all() {
        return repository.findAll();
    }

    @GetMapping("/seriespeople/{id_seriespeople}")
    SeriesPeople one(@PathVariable Integer id_seriespeople) {
        return repository.findOne(id_seriespeople);
    }

    @DeleteMapping("/seriespeople/{id_seriespeople}")
    Map<String, Boolean> deleteMoviePeople(@PathVariable Integer id_seriespeople) throws ResourceNotFoundException {
        SeriesPeople seriesPeople = repository.findOne(id_seriespeople);
        repository.delete(seriesPeople);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/seriespeople/{id_seriespeople}")
    ResponseEntity<SeriesPeople> update(@PathVariable Integer id_seriespeople, @RequestBody SeriesPeople seriesPeopleDetails) throws
            ResourceNotFoundException {
        SeriesPeople seriesPeople = repository.findOne(id_seriespeople);

        if (seriesPeopleDetails.getId_tvseries() != null && !(seriesPeopleDetails.getId_tvseries().equals(seriesPeople.getId_tvseries()))) {
            seriesPeople.setId_tvseries(seriesPeopleDetails.getId_tvseries());
        }
        if (seriesPeopleDetails.getId_person() != null && !(seriesPeopleDetails.getId_person().equals(seriesPeople.getId_person()))) {
            seriesPeople.setId_person(seriesPeopleDetails.getId_person());
        }
        if (seriesPeopleDetails.getCharacter_name() != null && !(seriesPeopleDetails.getCharacter_name().equals(seriesPeople.getCharacter_name()))) {
            seriesPeople.setCharacter_name(seriesPeopleDetails.getCharacter_name());
        }

        final SeriesPeople updatedseriespeople = repository.save(seriesPeople);
        return ResponseEntity.ok(updatedseriespeople);
    }
}
