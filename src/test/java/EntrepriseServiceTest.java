import Quick.Serve.Food.Services.EntrepriseService;
import Quick.Serve.Food.ServicesImplementations.EntrepriseServiceImplementation;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EntrepriseServiceTest {

    private final EntrepriseService entrepriseService = EntrepriseServiceImplementation.getInstance();

    @Test
    public void testGetAll(){

        List entreprises = entrepriseService.getAll();
        assertNotNull(entreprises);
        //assertFalse(entreprises.isEmpty());
    }

}
