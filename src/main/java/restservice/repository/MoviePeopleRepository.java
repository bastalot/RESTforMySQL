package restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restservice.entity.MoviePeople;

@RepositoryRestResource(path = "/moviepeople")
public interface MoviePeopleRepository extends JpaRepository<MoviePeople, Integer> {
}
