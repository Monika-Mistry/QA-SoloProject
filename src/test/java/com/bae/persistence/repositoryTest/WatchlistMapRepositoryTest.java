package com.bae.persistence.repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Watchlist;
import com.bae.persistence.repository.WatchlistMapRepository;
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

		assertEquals("{\"1\":{\"netflixId\":1,\"status\":\"PENDING\"}}",
				wmr.getWatchlist());
	}

	@Test
	public void addAProgramToWL() {
		String wL1JSON = "{\"netflixId\":1,\"status\":\"PENDING\"}";

		wmr.addAProgram(wL1JSON);

		assertEquals(1, wmr.getWatchlistMap().size());
		assertEquals(1, wmr.getWatchlistMap().get(1).getNetflixId());
	}

	@Test
	public void addTwoProgrammesToWL() {
		String wL1JSON = "{\"netflixId\":1,\"status\":\"PENDING\"}";
		String wL2JSON = "{\"netflixId\":2,\"status\":\"COMPLETED\"}";

		wmr.addAProgram(wL1JSON);
		wmr.addAProgram(wL2JSON);

		assertEquals(2, wmr.getWatchlistMap().size());
		assertEquals(2, wmr.getWatchlistMap().get(2).getNetflixId());
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
