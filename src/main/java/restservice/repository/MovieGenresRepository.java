package restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restservice.entity.MovieGenres;

@RepositoryRestResource(path = "/moviegenres")
public interface MovieGenresRepository extends JpaRepository<MovieGenres, Integer> {
}
