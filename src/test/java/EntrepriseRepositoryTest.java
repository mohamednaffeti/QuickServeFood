import Quick.Serve.Food.Models.Entreprise;
import Quick.Serve.Food.Repository.EntrepriseRepository;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class EntrepriseRepositoryTest {

    private final EntrepriseRepository entrepriseRepository = EntrepriseRepository.getInstance();

    @Test
    public void testGetAll() {
        List<Entreprise> entreprises = entrepriseRepository.getAll();


        assertNotNull(entreprises);
        assertFalse(entreprises.isEmpty());

        for (Entreprise entreprise : entreprises) {
            assertNotNull(entreprise.getId());
            assertNotNull(entreprise.getName());
            assertNotNull(entreprise.getPhonenumber());
            assertNotNull(entreprise.getSecondphonenumber());
            assertNotNull(entreprise.getEmail());
            assertNotNull(entreprise.getAddress());
            assertNotNull(entreprise.getHourlyrate());
            assertNotNull(entreprise.getDescription());
        }
    }
}
