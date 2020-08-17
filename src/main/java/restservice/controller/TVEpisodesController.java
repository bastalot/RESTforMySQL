package restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restservice.entity.TVEpisodes;
import restservice.repository.TVEpisodesRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TVEpisodesController {

    @Autowired
    private TVEpisodesRepository repository;

    @GetMapping("/tvepisodes/all")
    List<TVEpisodes> all() {
        return repository.findAll();
    }

    @PostMapping("/tvepisodes")
    TVEpisodes newTVEpisode(@RequestBody TVEpisodes newTVEpisodes) {
        return repository.save(newTVEpisodes);
    }

    @GetMapping("/tvepisodes/{id_tvepisodes}")
    TVEpisodes one(@PathVariable Integer id_tvepisodes) {
        return repository.findOne(id_tvepisodes);
    }

    @PutMapping("/tvepisodes/{id_tvepisodes}")
    ResponseEntity<TVEpisodes> update(@PathVariable Integer id_tvepisodes, @RequestBody TVEpisodes tvEpisodesDetails) throws ResourceNotFoundException {
        TVEpisodes tvEpisodes = repository.findOne(id_tvepisodes);

        if (tvEpisodesDetails.getTitle() != null)
            tvEpisodes.setTitle(tvEpisodesDetails.getTitle());

        final TVEpisodes updatedtvepisodes = repository.save(tvEpisodes);
        return ResponseEntity.ok(updatedtvepisodes);

    }

    @DeleteMapping("/tvepisodes/{id_tvepisodes}")
    Map<String, Boolean> deleteTVEpisode(@PathVariable Integer id_tvepisodes) throws  ResourceNotFoundException {
        TVEpisodes tvEpisodes = repository.findOne(id_tvepisodes);
        repository.delete(tvEpisodes);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
