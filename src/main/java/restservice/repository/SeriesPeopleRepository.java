package restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restservice.entity.SeriesPeople;

@RepositoryRestResource(path = "/seriespeople")
public interface SeriesPeopleRepository extends JpaRepository<SeriesPeople, Integer> {
}
