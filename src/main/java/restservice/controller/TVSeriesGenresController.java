package restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import restservice.entity.TVSeriesGenres;
import restservice.repository.TVSeriesGenresRepository;

import java.util.List;

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

}
