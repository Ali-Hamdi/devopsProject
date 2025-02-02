package devops.spring.project;

import devops.spring.project.entities.Departement;
import devops.spring.project.services.DepartementServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import devops.spring.project.repositories.DepartementRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DepartementServiceImplTest {

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private DepartementServiceImpl departementService;

    @BeforeEach
    void setUp() {
        // Clear the repository before each test
        departementRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        // Clear the repository after each test
        departementRepository.deleteAll();
    }

    @Test
    void testRetrieveAllDepartements() {
        Departement dep1 = new Departement();
        dep1.setNomDepart("IT");
        departementRepository.save(dep1);

        Departement dep2 = new Departement();
        dep2.setNomDepart("HR");
        departementRepository.save(dep2);

        List<Departement> result = departementService.retrieve();

        assertEquals(2, result.size());
    }

    @Test
    void testAddDepartement() {
        Departement departement = new Departement();
        departement.setNomDepart("Finance");

        Departement result = departementService.add(departement);

        assertNotNull(result.getIdDepart());
        assertEquals("Finance", result.getNomDepart());
    }

    @Test
    void testUpdateDepartement() {
        Departement departement = new Departement();
        departement.setNomDepart("Marketing");
        Departement savedDepartement = departementRepository.save(departement);

        assertNotNull(savedDepartement.getIdDepart(), "Saved departement should have a non-null ID");

        savedDepartement.setNomDepart("Sales");
        Departement updatedResult = departementService.update(savedDepartement);

        assertNotNull(updatedResult, "Updated result should not be null");
        assertEquals("Sales", updatedResult.getNomDepart());
    }


    @Test
    void testRetrieveDepartement() {
        Departement departement = new Departement();
        departement.setNomDepart("Operations");
        Departement savedDepartement = departementRepository.save(departement);

        Departement result = departementService.retrieveOne(savedDepartement.getIdDepart());

        assertNotNull(result);
        assertEquals("Operations", result.getNomDepart());
    }

    @Test
    void testDeleteDepartement() {
        Departement departement = new Departement();
        departement.setNomDepart("Logistics");
        Departement savedDepartement = departementRepository.save(departement);

        departementService.delete(savedDepartement.getIdDepart());

        assertFalse(departementRepository.findById(savedDepartement.getIdDepart()).isPresent());
    }
}
