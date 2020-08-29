package restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restservice.entity.Person;
import restservice.repository.PersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping("/person/all")
    List<Person> all() {
        return repository.findAll();
    }

    @PostMapping("/person")
    Person newPerson(@RequestBody Person newPerson) {
        return repository.save(newPerson);
    }

    @GetMapping("/person/{id_person}")
    Person one(@PathVariable Integer id_person) {
        return repository.findOne(id_person);
    }

    @PutMapping("/person/{id_person}")
    ResponseEntity<Person> update(@PathVariable Integer id_person, @RequestBody Person personDetails) throws ResourceNotFoundException {
        Person person = repository.findOne(id_person);

        if (personDetails.getPerson_name() != null)
            person.setPerson_name(personDetails.getPerson_name());

        final Person updatedperson = repository.save(person);
        return ResponseEntity.ok(updatedperson);

    }

    @DeleteMapping("/person/{id_person}")
    Map<String, Boolean> deletePerson(@PathVariable Integer id_person) throws ResourceNotFoundException {
        Person person = repository.findOne(id_person);
        repository.delete(person);;
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
