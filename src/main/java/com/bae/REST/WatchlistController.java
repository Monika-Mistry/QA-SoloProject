package com.bae.REST;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.service.WatchlistService;

@Path("watchlist/")
public class WatchlistController {

	@Inject
	private WatchlistService service;

	@Path("addAProgram")
	@POST
	@Produces({ "application/json" })
	public String addAProgram(String program) {
		return service.addAProgram(program);
	}

	@Path("getWatchlist")
	@GET
	@Produces({ "application/json" })
	public String getWatchlist() {
		return service.getWatchlist();
	}

	@Path("updateAProgram/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAProgram(@PathParam("id") int id, String status) {
		return service.updateWatchStatus(id, status);
	}

	@Path("removeAProgram/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String removeAProgram(@PathParam("id") int id) {
		return service.removeAProgram(id);
	}

}
