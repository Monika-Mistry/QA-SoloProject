package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.bae.persistence.domain.Watchlist;
import com.bae.util.JSONUtil;

public class WatchlistMapRepository implements WatchlistRepository {

	private Map<Integer, Watchlist> watchlistMap = new HashMap<>();
	private JSONUtil json = new JSONUtil();

	public String addAProgram(String program) {
		Watchlist newProgram = json.getObjectForJSON(program, Watchlist.class);

		watchlistMap.put(newProgram.getNetflixId(), newProgram);
		return "{\"message\":\"Program added to watchlist\"}";
	}

	public String getWatchlist() {
		return json.getJSONForObject(watchlistMap);
	}

	public String removeAProgram(int id) {
		watchlistMap.remove(id);
		return "{\"message\":\"Program removed from watchlist\"}";
	}

	public String updateWatchStatus(int id, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Integer, Watchlist> getWatchlistMap() {
		return watchlistMap;
	}

}
