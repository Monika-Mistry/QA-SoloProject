package com.bae.REST;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.bae.business.service.NetflixService;

@Path("netflix/")
public class NetflixController {

	@Inject
	private NetflixService service;

	public String addAProgram(String program) {
		return service.addAProgram(program);
	}

	public String getAllProgrammes() {
		return service.getAllProgrammes();
	}

	public String getAProgram(int id) {
		return service.getAProgram(id);
	}

	public String updateAProgram(int id, String program) {
		return service.updateAProgram(id, program);
	}

	public String removeAProgram(int id) {
		return service.removeAProgram(id);
	}

}
