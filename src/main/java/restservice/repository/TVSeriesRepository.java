package restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restservice.entity.TVSeries;

@RepositoryRestResource(path = "/tvseries")
public interface TVSeriesRepository extends JpaRepository<TVSeries, Integer> {
}
