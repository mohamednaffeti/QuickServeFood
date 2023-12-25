package Quick.Serve.Food.Controller;

import Quick.Serve.Food.Models.Entreprise;
import Quick.Serve.Food.Services.EntrepriseService;
import Quick.Serve.Food.ServicesImplementations.EntrepriseServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/entreprise")
public class EntrepriseController {
    final Logger logger = LoggerFactory.getLogger(EntrepriseController.class);
    private final EntrepriseService entrepriseService = EntrepriseServiceImplementation.getInstance();
    @GET
    @Path("/getAll")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        System.out.println("ok");
        System.out.println("ok");
        List<Entreprise> entreprises = entrepriseService.getAll();

        return Response.status(200).entity(entreprises).build();
    }
}
