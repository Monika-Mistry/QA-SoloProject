package com.bae.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.util.JSONUtil;

@Default
@Transactional(TxType.SUPPORTS)
public class GenreDatabaseRepository implements GenreRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonUtil;

	public String getAllGenres() {
		return null;
	}

	public String getAGenre(int id) {
		return null;
	}

}
