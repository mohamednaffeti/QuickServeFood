package Quick.Serve.Food.Services;

import Quick.Serve.Food.Models.Entreprise;
import Quick.Serve.Food.ServicesImplementations.EntrepriseServiceImplementation;

import java.util.List;

/**
 * An interface to define the contract between
 * the user and the business logic for managing Entreprises.
 */
public interface EntrepriseService {
        List <Entreprise> getAll();
        Entreprise addEntreprise(Entreprise entreprise);
        boolean deleteEntrepriseById(String id);
        Entreprise updateEntreprise(Entreprise newEntreprise);
}
