package com.bae.persistence.repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.repository.WatchlistMapRepository;

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
		wmr.getWatchlistMap().put(1, TestConstants.TEST_WATCHLIST1);

		assertEquals("{\"1\":" + TestConstants.TEST_WATCHLIST1STR + "}",
				wmr.getWatchlist());
	}

	@Test
	public void addAProgramToWL() {
		wmr.addAProgram(TestConstants.TEST_WATCHLIST1STR);

		assertEquals(1, wmr.getWatchlistMap().size());
		assertEquals(1, wmr.getWatchlistMap().get(1).getNetflixId());
	}

	@Test
	public void addTwoProgrammesToWL() {
		wmr.addAProgram(TestConstants.TEST_WATCHLIST1STR);
		wmr.addAProgram(TestConstants.TEST_WATCHLIST2STR);

		assertEquals(2, wmr.getWatchlistMap().size());
		assertEquals(2, wmr.getWatchlistMap().get(2).getNetflixId());
	}

	@Test
	public void addProgramAlreadyInWL() {
		wmr.getWatchlistMap().put(1, TestConstants.TEST_WATCHLIST1);
		wmr.addAProgram(TestConstants.TEST_WATCHLIST1STR);

		assertEquals(1, wmr.getWatchlistMap().size());

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
