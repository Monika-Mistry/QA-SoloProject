package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.bae.persistence.domain.Watchlist;

public class WatchlistMapRepository implements WatchlistRepository {

	private Map<Integer, Watchlist> watchlistMap = new HashMap<>();

	public String addAProgram(String program) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWatchlist() {
		return "{}";
	}

	public String removeAProgram(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateWatchStatus(int id, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Integer, Watchlist> getWatchlistMap() {
		return watchlistMap;
	}

}
