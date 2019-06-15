package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.WatchlistRepository;

public class WatchlistServiceImpl implements WatchlistService {

	@Inject
	private WatchlistRepository watchlistRepository;

	public String addAProgram(String program) {
		return watchlistRepository.addAProgram(program);
	}

	public String getWatchlist() {
		return watchlistRepository.getWatchlist();
	}

	public String removeAProgram(int id) {
		return watchlistRepository.removeAProgram(id);
	}

	public String updateWatchStatus(int id, String status) {
		watchlistRepository.updateWatchStatus(id, status);
	}

}
