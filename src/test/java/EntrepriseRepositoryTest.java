import Quick.Serve.Food.Models.Entreprise;
import Quick.Serve.Food.Repositories.EntrepriseRepository;
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
            //assertNotNull(entreprise.getDescription());
        }
    }
    @Test
    public void testAdd(){
        Entreprise entreprise = new Entreprise();
        entreprise.setId("114315112254110");
        entreprise.setName("FastFood");
        entreprise.setPhonenumber("56565656");
        entreprise.setSecondphonenumber("56564747");
        entreprise.setEmail("mohamed@gmail.com");
        entreprise.setAddress("Tunis");
        entreprise.setHourlyrate(9);
        entreprise.setDescription("ok");

        Entreprise entreprise1 = entrepriseRepository.addEntreprise(entreprise);
        System.out.println(entreprise1);
        assertNotNull(entreprise1);


    }
    @Test
    public void testDelete(){
        //arrange
        String id = "07bf4329-cc0d-44c8-9a2a-f09675cb5c77";
        //action
        boolean success = entrepriseRepository.deleteEntrepriseById(id);
        System.out.println(success);
        //assert
        //assertFalse(!success);

    }
    @Test
    public void testUpdate(){
        Entreprise entreprise = new Entreprise();
        entreprise.setId("11d82c80-e7af-42b5-82fb-0e9eb3227f9b");
        entreprise.setName("FastFooddd");
        entreprise.setPhonenumber("56565656");
        entreprise.setSecondphonenumber("56564747");
        entreprise.setEmail("mohamed@gmail.com");
        entreprise.setAddress("Tuniss");
        entreprise.setHourlyrate(9);
        entreprise.setDescription("ok");
        Entreprise entreprise1 = entrepriseRepository.updateEntreprise(entreprise);
        System.out.println(entreprise1);
        assertNotNull(entreprise1);
    }
}
