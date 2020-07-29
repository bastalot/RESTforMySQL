package restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restservice.entity.TVSeriesGenres;

@RepositoryRestResource(path = "/tvseriesgenres")
public interface TVSeriesGenresRepository extends JpaRepository<TVSeriesGenres, Integer> {
}
