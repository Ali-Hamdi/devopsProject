package devops.spring.project.repositories;

import devops.spring.project.entities.Etudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant,Integer> {
    public List<Etudiant> findEtudiantsByDepartement_IdDepart(Integer idDepart);
@Query("Select e From Etudiant e where e.nomE= :nomE and e.prenomE= :prenomE")
    public Etudiant findByNomEAndPrenomE(@Param("nomE") String nomE, @Param("prenomE") String prenomE);
}
