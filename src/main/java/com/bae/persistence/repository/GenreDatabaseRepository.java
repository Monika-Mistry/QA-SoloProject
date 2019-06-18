package com.bae.persistence.repository;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.persistence.domain.Genre;
import com.bae.util.JSONUtil;

@Default
@Transactional(TxType.SUPPORTS)
public class GenreDatabaseRepository implements GenreRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonUtil;

	public String getAllGenres() {
		Query query = manager.createQuery("SELECT g FROM Genre g");
		List<Genre> genres = query.getResultList();
		return jsonUtil.getJSONForObject(genres);
	}

	public String getAGenre(int id) {
		return null;
	}

}
