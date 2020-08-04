package restservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restservice.entity.TVSeassons;
import restservice.repository.TVSeassonsRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TVSeassonsController {

    @Autowired
    private TVSeassonsRepository repository;

    @GetMapping("/tvseassons/all")
    List<TVSeassons> all() {
        return repository.findAll();
    }

    @PostMapping("/tvseassons")
    TVSeassons newTVSeasson(@RequestBody TVSeassons newTVSeasson) {
        return repository.save(newTVSeasson);
    }

    @GetMapping("/tvseassons/{id_tvseassons}")
    TVSeassons one(@PathVariable Integer id_tvseassons) {
        return repository.findOne(id_tvseassons);
    }

    @PutMapping("/tvseassons/{id_tvseassons}")
    ResponseEntity<TVSeassons> update(@PathVariable Integer id_tvseassons, @RequestBody TVSeassons tvseassonsDetails) throws
            ResourceNotFoundException {
        TVSeassons tvSeassons = repository.findOne(id_tvseassons);

        if (tvseassonsDetails.getSummary() != null)
            tvSeassons.setSummary(tvseassonsDetails.getSummary());
        if (tvseassonsDetails.getSeasson_number() != null)
            tvSeassons.setSeasson_number(tvseassonsDetails.getSeasson_number());
        if (tvseassonsDetails.getId_tvseries() != null)
            tvSeassons.setId_tvseries(tvseassonsDetails.getId_tvseries());

        final TVSeassons updatedtvSeassons = repository.save(tvSeassons);
        return ResponseEntity.ok(updatedtvSeassons);
    }

    @DeleteMapping("/tvseassons/{id_tvseassons}")
    Map<String, Boolean> deleteTVSeassons(@PathVariable Integer id_tvseassons) throws ResourceNotFoundException {
        TVSeassons tvSeassons = repository.findOne(id_tvseassons);
        repository.delete(tvSeassons);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
