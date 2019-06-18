package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.bae.persistence.domain.Genre;

public class GenreMapRepository implements GenreRepository {

	private Map<Integer, Genre> genreMap = new HashMap<>();

	public String getAllGenres() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAGenre() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Integer, Genre> getGenreMap() {
		return genreMap;
	}

}
