package com.bae.REST;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.service.NetflixService;

@Path("netflix/")
public class NetflixController {

	@Inject
	private NetflixService service;

	@Path("addAProgram")
	@POST
	@Produces({ "application/json" })
	public String addAProgram(String program) {
		return service.addAProgram(program);
	}

	@Path("getAllProgrammes")
	@GET
	@Produces({ "application/json" })
	public String getAllProgrammes() {
		return service.getAllProgrammes();
	}

	@Path("getAProgram/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAProgram(@PathParam("id") int id) {
		return service.getAProgram(id);
	}

	@Path("updateAProgram/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAProgram(@PathParam("id") int id, String program) {
		return service.updateAProgram(id, program);
	}

	@Path("removeAProgram/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String removeAProgram(@PathParam("id") int id) {
		return service.removeAProgram(id);
	}

}
