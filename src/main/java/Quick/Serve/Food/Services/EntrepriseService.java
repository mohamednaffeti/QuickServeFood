package Quick.Serve.Food.Services;

import Quick.Serve.Food.Models.Entreprise;
import Quick.Serve.Food.ServicesImplementations.EntrepriseServiceImplementation;

import java.util.List;

public interface EntrepriseService {
        static EntrepriseService getInstance(){
                return EntrepriseServiceImplementation.getInstance();
        }
        List <Entreprise> getAll();
}
