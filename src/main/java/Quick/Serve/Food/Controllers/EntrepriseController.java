package Quick.Serve.Food.Controllers;

import Quick.Serve.Food.Models.Entreprise;
import Quick.Serve.Food.Services.EntrepriseService;
import Quick.Serve.Food.ServicesImplementations.EntrepriseServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
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
        List<Entreprise> entreprises = entrepriseService.getAll();
        return Response.status(200).entity(entreprises).build();
    }
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEntreprise(Entreprise entreprise){
        return null;
    }
}
