package com.bae.persistence.repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.domain.Watchlist;
import com.bae.persistence.repository.WatchlistDatabaseRepository;
import com.bae.util.JSONUtil;
import com.bae.util.TestConstants;

@RunWith(MockitoJUnitRunner.class)
public class WatchlistDatabaseRepositoryTest {

	@InjectMocks
	private WatchlistDatabaseRepository wdbr;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil jsonUtil;

	@Before
	public void setup() {
		jsonUtil = new JSONUtil();
		wdbr.setManager(manager);
		wdbr.setUtil(jsonUtil);

	}

	@Test
	public void returnNoProgrammesWhenDBEmpty() {
		Mockito.when(manager.createQuery(Mockito.anyString()))
				.thenReturn(query);
		List<Watchlist> watchlist = new ArrayList<>();
		Mockito.when(query.getResultList()).thenReturn(watchlist);
		assertEquals(TestConstants.EMPTYLIST, wdbr.getWatchlist());

	}

	@Test
	public void returnProgrammesWhenDBIsFilled() {
		Mockito.when(manager.createQuery(Mockito.anyString()))
				.thenReturn(query);
		List<Watchlist> watchlist = new ArrayList<>();
		watchlist.add(TestConstants.TEST_WATCHLIST1);
		Mockito.when(query.getResultList()).thenReturn(watchlist);
		assertEquals(TestConstants.EMPTYLIST, wdbr.getWatchlist());
	}

	@Test
	public void addAProgram() {
		fail("TODO");
	}

	@Test
	public void removeAProgramThatDoesNotExist() {
		fail("TODO");
	}

	@Test
	public void removeAProgramThatDoesExist() {
		fail("TODO");
	}

	@Test
	public void updateWatchStatus() {
		fail("TODO");
	}

}
