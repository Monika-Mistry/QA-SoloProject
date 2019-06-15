package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.bae.persistence.domain.Watchlist;
import com.bae.util.JSONUtil;
import com.bae.util.WatchStatus;

public class WatchlistMapRepository implements WatchlistRepository {

	private Map<Integer, Watchlist> watchlistMap = new HashMap<>();
	private JSONUtil json = new JSONUtil();

	public String addAProgram(String program) {
		Watchlist newProgram = json.getObjectForJSON(program, Watchlist.class);

		if (!watchlistMap.containsValue(newProgram)) {

			watchlistMap.put(newProgram.getNetflixId(), newProgram);
			return "{\"message\":\"Program added to watchlist\"}";
		} else {
			return "{\"message\":\"Program already exists\"}";
		}
	}

	public String getWatchlist() {
		return json.getJSONForObject(watchlistMap);
	}

	public String removeAProgram(int id) {
		if (watchlistMap.containsKey(id)) {
			watchlistMap.remove(id);
			return "{\"message\":\"Program removed from watchlist\"}";
		} else {
			return "{\"message\":\"Program does not exist\"}";
		}
	}

	public String updateWatchStatus(int id, String status) {
		if (watchlistMap.containsKey(id)) {
			Watchlist program = watchlistMap.get(id);
			switch (status) {
			case "Not Started":
				program.setStatus(WatchStatus.PENDING);
				watchlistMap.replace(id, program);
				break;
			case "Watching":
				program.setStatus(WatchStatus.INPROGRESS);
				watchlistMap.replace(id, program);
				break;
			case "Watched":
				program.setStatus(WatchStatus.COMPLETED);
				watchlistMap.replace(id, program);
				break;
			default:
				watchlistMap.replace(id, program);
				break;
			}
			return "{\"message\":\"Program watch status updated\"}";
		} else {
			return "{\"message\":\"Program does not exist\"}";
		}
	}

	public Map<Integer, Watchlist> getWatchlistMap() {
		return watchlistMap;
	}

}
