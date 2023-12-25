package Quick.Serve.Food.Responses;

import Quick.Serve.Food.Models.Entreprise;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Response Model for Json Format
 */
public class EntrepriseResponse {
    private boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Entreprise entreprise;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Entreprise> entreprises;

    public EntrepriseResponse(boolean success) {
        this.success = success;
    }

    public EntrepriseResponse(boolean success, List<Entreprise> entreprises) {
        this.success = success;
        this.entreprises = entreprises;
    }

    public EntrepriseResponse(boolean success, Entreprise entreprise) {
        this.success = success;
        this.entreprise = entreprise;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public boolean isSuccess() {
        return success;
    }


    public List<Entreprise> getEntreprises() {
        return entreprises;
    }


}
