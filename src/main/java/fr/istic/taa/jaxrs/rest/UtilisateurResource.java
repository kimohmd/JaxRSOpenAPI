package fr.istic.taa.jaxrs.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.UtilisateurDAO;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import io.swagger.v3.oas.annotations.Parameter;


@Path("/utilisateur")
@Produces({"application/json", "application/xml"})

public class UtilisateurResource {
	UtilisateurDAO utilisateurDao = new UtilisateurDAO();
	@Produces("application/json")
	@GET
  @Path("/{utilisateurId}")
  public Utilisateur getUtilisateurById(@PathParam("utilisateurId") Long utilisateurId)  {
     
      return utilisateurDao.findOne(utilisateurId);
  }
  @Path("/addUtilisateur")
  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public Response addUtilisateur(
      @Parameter(description = "Utilisateur a ajouter dans le store", required = true) Utilisateur utilisateur) {
	  utilisateurDao.save(utilisateur);
    return Response.ok().entity(utilisateur).build();
  }
}