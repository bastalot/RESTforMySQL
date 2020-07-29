package restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restservice.entity.TVEpisodes;

@RepositoryRestResource(path = "/tvepisodes")
public interface TVEpisodesRepository extends JpaRepository<TVEpisodes, Integer> {
}
