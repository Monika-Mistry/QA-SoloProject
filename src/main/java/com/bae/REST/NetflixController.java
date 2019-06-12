package com.bae.REST;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.bae.business.service.NetflixService;

@Path("netflix/")
public class NetflixController {

	@Inject
	private NetflixService service;

	public String addAProgram(String program) {
		return null;

	}

	public String getAllProgrammes() {
		return null;
	}

	public String getAProgram(int id) {
		return null;
	}

	public String updateAProgram(int id, String program) {
		return null;
	}

	public String removeAProgram(int id) {
		return null;
	}

}
