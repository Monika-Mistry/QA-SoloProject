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
		wmr.getWatchlist();
		assertEquals(0, wmr.getWatchlistMap().size());
	}

	@Test
	public void returnProgrammesWhenMapFilled() {
		fail("TODO");
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
