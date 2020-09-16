package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.FicheDAO;
import fr.istic.taa.jaxrs.domain.Fiche;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/fiche")
@Produces({"application/json", "application/xml"})

public class FicheResource {
	FicheDAO ficheDao = new FicheDAO();
	@Produces("application/json")
	@GET
  @Path("/{ficheId}")
  public Fiche getFicheById(@PathParam("ficheId") Long ficheId)  {
     
      return ficheDao.findOne(ficheId);
  }
  @Path("/addFiche")
  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public Response addFiche(
      @Parameter(description = "Fiche a ajouter dans le store", required = true) Fiche fiche) {
	  ficheDao.save(fiche);
    return Response.ok().entity(fiche).build();
  }
}