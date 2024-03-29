package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.bae.persistence.domain.Watchlist;
import com.bae.util.Constants;
import com.bae.util.JSONUtil;
import com.bae.util.WatchStatus;

@Alternative
public class WatchlistMapRepository implements WatchlistRepository {

	private Map<Integer, Watchlist> watchlistMap = new HashMap<>();
	private JSONUtil json = new JSONUtil();

	public String addAProgram(String program) {
		Watchlist newProgram = json.getObjectForJSON(program, Watchlist.class);

		if (!watchlistMap.containsKey(newProgram.getNetflixId())) {

			watchlistMap.put(newProgram.getNetflixId(), newProgram);
			return Constants.PROGRAMADDED;
		} else {
			return Constants.PROGRAMEXISTS;
		}
	}

	public String getWatchlist() {
		return json.getJSONForObject(watchlistMap);
	}

	public String removeAProgram(int id) {
		if (watchlistMap.containsKey(id)) {
			watchlistMap.remove(id);
			return Constants.PROGRAMREMOVED;
		} else {
			return Constants.PROGRAMNOTEXIST;
		}
	}

	public String updateWatchStatus(int id, String status) {
		if (watchlistMap.containsKey(id)) {
			Watchlist program = watchlistMap.get(id);

			if (status.equals(Constants.PENDINGSTR)) {
				program.setStatus(WatchStatus.PENDING);
				return json.getJSONForObject(program);
			} else if (status.equals(Constants.INPROGRESSSTR)) {
				program.setStatus(WatchStatus.INPROGRESS);
				return json.getJSONForObject(program);
			} else if (status.equals(Constants.COMPLETESTR)) {
				program.setStatus(WatchStatus.COMPLETED);
				return json.getJSONForObject(program);
			} else {
				return json.getJSONForObject(program);

			}
		} else {
			return Constants.PROGRAMNOTEXIST;
		}
	}

	public Map<Integer, Watchlist> getWatchlistMap() {
		return watchlistMap;
	}

}
