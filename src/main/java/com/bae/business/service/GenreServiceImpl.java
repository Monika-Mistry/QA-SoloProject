package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.GenreRepository;

public class GenreServiceImpl implements GenreService {

	@Inject
	private GenreRepository genreRepository;

	public String getAllGenres() {
		return genreRepository.getAllGenres();
	}

	public String getAGenre(int id) {
		return genreRepository.getAGenre(id);
	}

}
