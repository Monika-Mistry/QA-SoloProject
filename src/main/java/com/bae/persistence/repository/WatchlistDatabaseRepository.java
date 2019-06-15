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
public class WatchlistDatabaseRepository implements WatchlistRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonUtil;

	@Transactional(TxType.REQUIRED)
	public String addAProgram(String program) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWatchlist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(TxType.REQUIRED)
	public String removeAProgram(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(TxType.REQUIRED)
	public String updateWatchStatus(int id, String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
