package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.bae.persistence.domain.Genre;
import com.bae.util.JSONUtil;

public class GenreMapRepository implements GenreRepository {

	private Map<Integer, Genre> genreMap = new HashMap<>();
	private JSONUtil jsonUtil = new JSONUtil();

	public String getAllGenres() {
		return jsonUtil.getJSONForObject(genreMap);
	}

	public String getAGenre(int id) {

		return null;
	}

	public Map<Integer, Genre> getGenreMap() {
		return genreMap;
	}

}
