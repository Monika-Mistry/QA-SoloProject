package com.bae.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.persistence.domain.Netflix;
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

		return program;
	}

	public String getAllProgrammes() {
		Query query = manager.createQuery("SELECT n FROM netflix n");

		Collection<Netflix> programmes = (Collection<Netflix>) query
				.getResultList();
		return jsonUtil.getJSONForObject(programmes);
	}

	public String getAProgram(int id) {

		if (manager.find(Netflix.class, id) != null) {
			return jsonUtil.getJSONForObject(manager.find(Netflix.class, id));
		} else {
			return "{\"message\": \"Program does not exist\"}";
		}
	}

	public String updateAProgram(int id, String program) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(TxType.REQUIRED)
	public String removeAProgram(int id) {
		Netflix program = manager.find(Netflix.class, id);
		if (program != null) {
			manager.remove(program);
			return "{\"message\": \"" + program.getTitle() + " removed\"}";
		} else {
			return "{\"message\": \"Program does not exist\"}";
		}
	}

}
