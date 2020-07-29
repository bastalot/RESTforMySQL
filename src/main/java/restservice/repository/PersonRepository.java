package restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restservice.entity.Person;

@RepositoryRestResource(path = "/person")
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
