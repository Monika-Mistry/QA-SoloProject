package com.bae.persistence.repository;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.persistence.domain.Watchlist;
import com.bae.util.Constants;
import com.bae.util.JSONUtil;
import com.bae.util.WatchStatus;

@Default
@Transactional(TxType.SUPPORTS)
public class WatchlistDatabaseRepository implements WatchlistRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonUtil;

	@Transactional(TxType.REQUIRED)
	public String addAProgram(String program) {
		Watchlist newProgram = jsonUtil.getObjectForJSON(program,
				Watchlist.class);

		manager.persist(newProgram);

		return program;
	}

	public String getWatchlist() {
		Query query = manager.createQuery(Constants.GETWATCHLISTQUERY);

		List<Watchlist> programmes = query.getResultList();
		return jsonUtil.getJSONForObject(programmes);
	}

	@Transactional(TxType.REQUIRED)
	public String removeAProgram(int id) {
		Watchlist program = manager.find(Watchlist.class, id);
		if (program != null) {
			manager.remove(program);
			return jsonUtil.getJSONForObject(program);
		} else {
			return Constants.PROGRAMNOTEXIST;
		}
	}

	@Transactional(TxType.REQUIRED)
	public String updateWatchStatus(int id, String status) {
		Watchlist program = manager.find(Watchlist.class, id);
		if (program != null) {
			if(status.equals(Constants.PENDINGSTR)) {
				program.setStatus(WatchStatus.PENDING);
				return jsonUtil.getJSONForObject(program);
			} else if (status.equals(Constants.INPROGRESSSTR)) {
				program.setStatus(WatchStatus.INPROGRESS);
				return jsonUtil.getJSONForObject(program);}
			else if (status.equals(Constants.COMPLETESTR)) {
				program.setStatus(WatchStatus.COMPLETED);
				return jsonUtil.getJSONForObject(program);}
			else {
				return jsonUtil.getJSONForObject(program);
			}

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

}
