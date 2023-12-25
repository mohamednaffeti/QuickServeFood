package Quick.Serve.Food.Controllers;

import Quick.Serve.Food.Models.Entreprise;
import Quick.Serve.Food.Responses.EntrepriseResponse;
import Quick.Serve.Food.Services.EntrepriseService;
import Quick.Serve.Food.ServicesImplementations.EntrepriseServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Path("/entreprise")
public class EntrepriseController {
    boolean success;
    final Logger logger = LoggerFactory.getLogger(EntrepriseController.class);
    private final EntrepriseService entrepriseService = EntrepriseServiceImplementation.getInstance();
    @GET
    @Path("/getAll")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<Entreprise> entreprises = entrepriseService.getAll();
        success = !entreprises.isEmpty();
        EntrepriseResponse response = new EntrepriseResponse(success,entreprises);
        return Response.status(200).entity(response).build();
    }
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEntreprise(Entreprise entreprise){
        Entreprise addedEntreprise = entrepriseService.addEntreprise(entreprise);
        success = addedEntreprise != null;
        EntrepriseResponse response = new EntrepriseResponse( success , addedEntreprise);
        return (response.getEntreprise() != null) ? Response.status(Response.Status.CREATED).entity(response).build()
         : Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEntreprise(@PathParam("id") String id) {
        success = entrepriseService.deleteEntrepriseById(id);
        EntrepriseResponse response = new EntrepriseResponse(success);
        return success ? Response.status(Response.Status.OK).entity(response).build()
                : Response.status(Response.Status.NOT_FOUND).entity(response).build();
    }
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEntreprise(Entreprise newEntreprise) {
        Entreprise updatedEntreprise = entrepriseService.updateEntreprise(newEntreprise);
        success = updatedEntreprise != null;
        EntrepriseResponse response = new EntrepriseResponse(success,updatedEntreprise);

        return success ? Response.status(Response.Status.OK).entity(response).build()
                : Response.status(Response.Status.NOT_FOUND).entity(response).build();
    }

}
