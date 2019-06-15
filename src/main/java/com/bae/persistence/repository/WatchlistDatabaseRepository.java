package com.bae.persistence.repository;

import javax.enterprise.inject.Default;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Default
@Transactional(TxType.SUPPORTS)
public class WatchlistDatabaseRepository implements WatchlistRepository {

	public String addAProgram(String program) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWatchlist() {
		// TODO Auto-generated method stub
		return null;
	}

	public String removeAProgram(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateWatchStatus(int id, String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
