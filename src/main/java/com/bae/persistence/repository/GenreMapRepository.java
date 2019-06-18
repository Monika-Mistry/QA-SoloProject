package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.bae.persistence.domain.Genre;

public class GenreMapRepository implements GenreRepository {

	private Map<Integer, Genre> genreMap = new HashMap<>();

	public String getAllGenres() {
		return "{}";
	}

	public String getAGenre() {
		return null;
	}

	public Map<Integer, Genre> getGenreMap() {
		return genreMap;
	}

}
