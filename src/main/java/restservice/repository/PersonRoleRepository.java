package restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restservice.entity.PersonRole;

@RepositoryRestResource(path = "/personrole")
public interface PersonRoleRepository extends JpaRepository<PersonRole, Integer> {
}
