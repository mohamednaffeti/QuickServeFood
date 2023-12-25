package Quick.Serve.Food.ServicesImplementations;

import Quick.Serve.Food.Models.Entreprise;
import Quick.Serve.Food.Repository.EntrepriseRepository;
import Quick.Serve.Food.Services.EntrepriseService;

import java.util.List;

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
        for(Entreprise e : entreprises){
            System.out.println(e);
        }
        return entreprises;
    }
}
