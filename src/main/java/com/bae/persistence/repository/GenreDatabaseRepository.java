package com.bae.persistence.repository;

import javax.enterprise.inject.Default;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Default
@Transactional(TxType.SUPPORTS)
public class GenreDatabaseRepository implements GenreRepository {

	@Override
	public String getAllGenres() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAGenre(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
