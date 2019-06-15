package com.bae.persistence.repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

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
		assertTrue(wmr.addAProgram(TestConstants.TEST_WATCHLIST1STR).contains(
				"already exists"));

	}

	@Test
	public void removeProgramFromWL() {
		wmr.getWatchlistMap().put(1, TestConstants.TEST_WATCHLIST1);

		wmr.removeAProgram(1);

		assertEquals(0, wmr.getWatchlistMap().size());
	}

	@Test
	public void removeTwoProgrammesFromWL() {
		wmr.getWatchlistMap().put(1, TestConstants.TEST_WATCHLIST1);
		wmr.getWatchlistMap().put(2, TestConstants.TEST_WATCHLIST2);

		wmr.removeAProgram(1);
		wmr.removeAProgram(2);

		assertEquals(0, wmr.getWatchlistMap().size());
	}

	@Test
	public void removeProgramNotInWL() {
		assertTrue(wmr.removeAProgram(1).contains("does not exist"));
	}

	@Test
	public void updateWatchStatusForProgramInWL() {
		wmr.getWatchlistMap().put(1, TestConstants.TEST_WATCHLIST1);
		wmr.updateWatchStatus(1, "watching");

		assertTrue(wmr.getWatchlistMap().get(1).getStatus()
				.equals(WatchStatus.INPROGRESS));
	}

	@Test
	public void updateWatchStatusForProgramNotInWL() {
		assertTrue(wmr.updateWatchStatus(1, "watching").contains(
				"does not exist"));

	}

}
