package devops.spring.project.repositories;

import devops.spring.project.entities.Universite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository extends CrudRepository<Universite,Integer> {


}
