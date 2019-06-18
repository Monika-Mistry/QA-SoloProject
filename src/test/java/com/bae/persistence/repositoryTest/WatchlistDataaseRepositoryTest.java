package com.bae.persistence.repositoryTest;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.WatchlistDatabaseRepository;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class WatchlistDataaseRepositoryTest {

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
		fail("TODO");
	}

	@Test
	public void returnProgrammesWhenDBIsFilled() {
		fail("TODO");
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
