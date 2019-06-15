package com.bae.persistence.repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Watchlist;
import com.bae.persistence.repository.WatchlistMapRepository;
import com.bae.util.JSONUtil;
import com.bae.util.WatchStatus;

public class WatchlistMapRepositoryTest {

	private WatchlistMapRepository wmr;

	@Before
	public void setup() {
		wmr = new WatchlistMapRepository();

	}

	@Test
	public void returnNoProgrammesWhenMapEmpty() {

		assertEquals(0, wmr.getWatchlistMap().size());
		assertEquals("{}", wmr.getWatchlist());
	}

	@Test
	public void returnProgrammesWhenMapFilled() {
		Watchlist wL1 = new Watchlist(1, WatchStatus.PENDING);
		wmr.getWatchlistMap().put(1, wL1);

		assertEquals("{\"1\":{\"netflixId\":1,\"status\":\"PENDING\"}",
				wmr.getWatchlist());
	}

	@Test
	public void addAProgramToWL() {
		fail("TODO");
	}

	@Test
	public void addTwoProgrammesToWL() {
		fail("TODO");
	}

	@Test
	public void addProgramAlreadyInWL() {
		fail("TODO");
	}

	@Test
	public void removeProgramFromWL() {
		fail("TODO");
	}

	@Test
	public void removeTwoProgrammesFromWL() {
		fail("TODO");
	}

	@Test
	public void removeProgramNotInWL() {
		fail("TODO");
	}

	@Test
	public void updateWatchStatus() {
		fail("TODO");
	}

}
