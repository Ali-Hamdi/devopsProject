package devops.spring.project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import devops.spring.project.entities.Equipe;

@Repository
public interface EquipeRepository extends CrudRepository<Equipe,Integer> {



}
