package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.bae.persistence.domain.Netflix;
import com.bae.util.JSONUtil;

public class NetflixMapRepository implements NetflixRepository {

	private Map<Integer, Netflix> netflixMap = new HashMap<Integer, Netflix>();

	public String addAProgram(String program) {
		JSONUtil jsonUtil = new JSONUtil();
		Netflix newProgram = jsonUtil.getObjectForJSON(program, Netflix.class);

		netflixMap.put(newProgram.getNetflixId(), newProgram);
		return null;
	}

	public String getAllProgrammes() {
		JSONUtil jsonUtil = new JSONUtil();
		return jsonUtil.getJSONForObject(netflixMap);
	}

	public String getAProgram(String program) {

		return null;
	}

	public String updateAProgram(int id, String program) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeAProgram(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Integer, Netflix> getNetflixMap() {
		return netflixMap;
	}

}
