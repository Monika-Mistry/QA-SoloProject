package com.bae.REST;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.service.GenreService;

@Path("genre/")
public class GenreController {

	@Inject
	private GenreService service;

	@Path("getAllGenres")
	@GET
	@Produces({ "application/json" })
	public String getAllGenres() {
		return service.getAllGenres();

	}

	@Path("getAGenre/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAGenre(@PathParam("id") int id) {
		return service.getAGenre(id);

	}
}
