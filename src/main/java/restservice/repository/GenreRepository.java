package restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restservice.entity.Genre;

@RepositoryRestResource(path = "/genre")
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
