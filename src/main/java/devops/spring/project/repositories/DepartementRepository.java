package devops.spring.project.repositories;

import devops.spring.project.entities.Departement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends CrudRepository<Departement,Integer> {



}
