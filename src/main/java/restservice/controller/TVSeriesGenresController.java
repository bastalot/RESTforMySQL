package restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import restservice.entity.TVSeriesGenres;
import restservice.repository.TVSeriesGenresRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TVSeriesGenresController {

    @Autowired
    private TVSeriesGenresRepository repository;

    @PostMapping("/tvseriesgenres")
    TVSeriesGenres newTvSeriesGenres(@RequestBody TVSeriesGenres newTvSeriesGenres) {
        return repository.save(newTvSeriesGenres);
    }

    @GetMapping("/tvseriesgenres/all")
    List<TVSeriesGenres> all() {
        return repository.findAll();
    }

    @DeleteMapping("/tvseriesgenres/{id_tvseriesgenres}")
    Map<String, Boolean> deleteTvSeriesGenres(@PathVariable Integer id_tvseriesgenres) throws ResourceNotFoundException {
        TVSeriesGenres tvSeriesGenres = repository.findOne(id_tvseriesgenres);
        repository.delete(tvSeriesGenres);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  response;
    }

}
