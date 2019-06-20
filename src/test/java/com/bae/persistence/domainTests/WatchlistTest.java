package com.bae.persistence.domainTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bae.persistence.domain.Watchlist;
import com.bae.util.WatchStatus;

public class WatchlistTest {
	
	private Watchlist watchlist = new Watchlist(1, WatchStatus.PENDING);
	
	@Test
	public void getNetflixId() {
		assertEquals(1, watchlist.getNetflixId());
	}
	
	@Test
	public void getWatchStatus() {
		assertEquals(WatchStatus.PENDING, watchlist.getStatus());
	}

}
