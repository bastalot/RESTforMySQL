package restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restservice.entity.Movie;
import restservice.entity.TVSeries;
import restservice.repository.TVSeriesRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TVSeriesController {

    @Autowired
    private TVSeriesRepository repository;

    @GetMapping("/tvseries/all")
    List<TVSeries> all() {
        return repository.findAll();
    }

    @PostMapping("/tvseries")
    TVSeries newTVSeries(@RequestBody TVSeries newTVSeries) {
        return repository.save(newTVSeries);
    }

    @GetMapping("/tvseries/{id_tvseries}")
    TVSeries one(@PathVariable Integer id_tvseries) {
        return repository.findOne(id_tvseries);
    }

    @PutMapping("/tvseries/{id_tvseries}")
    ResponseEntity<TVSeries> update(@PathVariable Integer id_tvseries, @RequestBody TVSeries tvseriesDetails) throws ResourceNotFoundException {
        TVSeries tvseries = repository.findOne(id_tvseries);

        if (tvseriesDetails.getTitle() != null)
            tvseries.setTitle(tvseriesDetails.getTitle());
        if (tvseriesDetails.getStart_year() != null)
        tvseries.setStart_year(tvseriesDetails.getStart_year());
        if (tvseriesDetails.getEnd_year() != null)
        tvseries.setEnd_year(tvseriesDetails.getEnd_year());
        if (tvseriesDetails.getPoster() != null){
            tvseries.setPoster(tvseriesDetails.getPoster());
        }


        final TVSeries updatedtvseries = repository.save(tvseries);
        return ResponseEntity.ok(updatedtvseries);

    }

    @DeleteMapping("/tvseries/{id_tvseries}")
    Map<String, Boolean> deleteTVSeries(@PathVariable Integer id_tvseries) throws ResourceNotFoundException {
       TVSeries tvSeries = repository.findOne(id_tvseries);
       repository.delete(tvSeries);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;

    }

   /* @GetMapping("/movie/{id_movie}/poster")
    byte[] poster(@PathVariable Integer id_movie) {
        return repository.findOne(id_movie).getPoster();
    } */
/*
    @GetMapping("/movie/{id_movie}/poster")
    String poster(@PathVariable Integer id_movie) {
        return Base64.getEncoder().encodeToString(repository.findOne(id_movie).getPoster());
    }
*/

}
