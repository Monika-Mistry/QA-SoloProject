package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.bae.persistence.domain.Netflix;
import com.bae.util.JSONUtil;

public class NetflixMapRepository implements NetflixRepository {

	private Map<Integer, Netflix> netflixMap = new HashMap<Integer, Netflix>();
	private JSONUtil jsonUtil = new JSONUtil();

	public String addAProgram(String program) {
		Netflix newProgram = jsonUtil.getObjectForJSON(program, Netflix.class);

		netflixMap.put(newProgram.getNetflixId(), newProgram);
		return program;
	}

	public String getAllProgrammes() {
		return jsonUtil.getJSONForObject(netflixMap);
	}

	public String getAProgram(int id) {

		return null;
	}

	public String updateAProgram(int id, String program) {
		Netflix updatedProgram = jsonUtil.getObjectForJSON(program,
				Netflix.class);
		netflixMap.replace(id, updatedProgram);

		return jsonUtil.getJSONForObject(netflixMap.get(id));
	}

	public String removeAProgram(int id) {
		if (netflixMap.containsKey(id)) {
			netflixMap.remove(id);
			return jsonUtil.getJSONForObject(netflixMap.get(id));
		}

		else {
			return "{\"message\": \"Program does not exist\"}";
		}
	}

	public Map<Integer, Netflix> getNetflixMap() {
		return netflixMap;
	}

}
