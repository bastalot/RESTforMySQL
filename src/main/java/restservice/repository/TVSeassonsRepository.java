package restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restservice.entity.TVSeassons;

@RepositoryRestResource(path = "/tvseassons")
public interface TVSeassonsRepository extends JpaRepository<TVSeassons, Integer> {
}
