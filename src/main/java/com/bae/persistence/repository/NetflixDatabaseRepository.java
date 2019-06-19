package com.bae.persistence.repository;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.persistence.domain.Netflix;
import com.bae.util.Constants;
import com.bae.util.JSONUtil;

@Default
@Transactional(TxType.SUPPORTS)
public class NetflixDatabaseRepository implements NetflixRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonUtil;

	@Transactional(TxType.REQUIRED)
	public String addAProgram(String program) {
		Netflix newProgram = jsonUtil.getObjectForJSON(program, Netflix.class);

		manager.persist(newProgram);

		return jsonUtil.getJSONForObject(newProgram);
	}

	public String getAllProgrammes() {
		Query query = manager.createQuery(Constants.GETALLNETFLIXQUERY);

		List<Netflix> programmes = query.getResultList();
		return jsonUtil.getJSONForObject(programmes);
	}

	public String getAProgram(int id) {

		if (manager.find(Netflix.class, id) != null) {
			return jsonUtil.getJSONForObject(manager.find(Netflix.class, id));
		} else {
			return Constants.PROGRAMNOTEXIST;
		}
	}

	@Transactional(TxType.REQUIRED)
	public String updateAProgram(int id, String program) {
		Netflix programToUpdate = manager.find(Netflix.class, id);
		Netflix updatedProgram = jsonUtil.getObjectForJSON(program,
				Netflix.class);
		if (programToUpdate != null) {
			programToUpdate.setCountry(updatedProgram.getCountry());
			programToUpdate.setGenreId(updatedProgram.getGenreId());
			programToUpdate.setTitle(updatedProgram.getTitle());

			return jsonUtil.getJSONForObject(manager.find(Netflix.class, id));
		} else {
			return Constants.PROGRAMNOTEXIST;
		}
	}

	@Transactional(TxType.REQUIRED)
	public String removeAProgram(int id) {
		Netflix program = manager.find(Netflix.class, id);
		if (program != null) {
			manager.remove(program);
			return "{\"message\": \"" + program.getTitle() + " removed\"}";
		} else {
			return Constants.PROGRAMNOTEXIST;
		}
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil jsonUtil) {
		this.jsonUtil = jsonUtil;
	}

	public String getTitle(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
