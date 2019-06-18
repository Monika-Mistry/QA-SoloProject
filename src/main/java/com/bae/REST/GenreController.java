package com.bae.REST;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.bae.business.service.GenreService;

@Path("genre/")
public class GenreController {

	@Inject
	private GenreService service;

	public String getAllGenres() {
		return null;

	}

	public String getAGenre(int id) {
		return null;

	}
}
