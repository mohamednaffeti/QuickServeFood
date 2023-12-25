package Quick.Serve.Food.ServicesImplementations;

import Quick.Serve.Food.Models.Entreprise;
import Quick.Serve.Food.Repositories.EntrepriseRepository;
import Quick.Serve.Food.Services.EntrepriseService;

import java.util.List;

/**
 * Business Logic
 */
public class EntrepriseServiceImplementation implements EntrepriseService {

    private final EntrepriseRepository entrepriseRepository = EntrepriseRepository.getInstance();
    private static EntrepriseServiceImplementation instance;

    private EntrepriseServiceImplementation() {
    }
    public static synchronized EntrepriseServiceImplementation getInstance() {
        if (instance == null) {
            instance = new EntrepriseServiceImplementation();
        }
        return instance;
    }
    @Override
    public List<Entreprise> getAll() {
        List<Entreprise> entreprises= entrepriseRepository.getAll();
        return entreprises;
    }

    @Override
    public Entreprise addEntreprise(Entreprise entreprise) {
        return entrepriseRepository.addEntreprise(entreprise);
    }

    @Override
    public boolean deleteEntrepriseById(String id) {
        return entrepriseRepository.deleteEntrepriseById(id);
    }

    @Override
    public Entreprise updateEntreprise(Entreprise newEntreprise) {
        return entrepriseRepository.updateEntreprise(newEntreprise);
    }

}
