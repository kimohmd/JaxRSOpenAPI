package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.TableauDAO;
import fr.istic.taa.jaxrs.dao.generic.UtilisateurDAO;
import fr.istic.taa.jaxrs.domain.Tableau;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/tableau")
@Produces({"application/json", "application/xml"})

public class TableauResource {
	TableauDAO tableauDao = new TableauDAO();
	@Produces("application/json")
	@GET
  @Path("/{tableauId}")
  public Tableau getTableauById(@PathParam("tableauId") Long tableauId)  {
     
      return tableauDao.findOne(tableauId);
  }
  @Path("/addTableau")
  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public Response addTableau(
      @Parameter(description = "Tableau a ajouter dans le store", required = true) Tableau tableau) {
	  tableauDao.save(tableau);
    return Response.ok().entity(tableau).build();
  }
}