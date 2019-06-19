package com.bae.persistence.repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

import com.bae.persistence.domain.Netflix;
import com.bae.persistence.repository.NetflixDatabaseRepository;
import com.bae.util.JSONUtil;
import com.bae.util.TestConstants;

@RunWith(MockitoJUnitRunner.class)
public class NetflixDatabaseRepositoryTest {

	@InjectMocks
	private NetflixDatabaseRepository ndbr;

	@Mock
	private EntityManager manager;

	private JSONUtil jsonUtil;

	@Mock
	private Query query;

	private Netflix program1;

	@Before
	public void setup() {
		ndbr.setManager(manager);
		jsonUtil = new JSONUtil();
		ndbr.setUtil(jsonUtil);
		program1 = new Netflix(1, "UK", "OITNB", 1);
	}

	@Test
	public void returnProgrammesWhenMapIsFilled() {
		Mockito.when(manager.createQuery(Mockito.anyString()))
				.thenReturn(query);
		List<Netflix> programmes = new ArrayList<Netflix>();
		programmes.add(program1);
		Mockito.when(query.getResultList()).thenReturn(programmes);
		assertEquals(TestConstants.TEST_PROGRAM1LIST, ndbr.getAllProgrammes());
	}

	@Test
	public void returnNoProgrammesWhenMapEmpty() {
		Mockito.when(manager.createQuery(Mockito.anyString()))
				.thenReturn(query);
		List<Netflix> programmes = new ArrayList<Netflix>();
		Mockito.when(query.getResultList()).thenReturn(programmes);
		assertEquals(TestConstants.EMPTYLIST, ndbr.getAllProgrammes());
	}

	@Test
	public void addAProgram() {
		assertEquals(TestConstants.TEST_PROGRAM1STR,
				ndbr.addAProgram(TestConstants.TEST_PROGRAM1STR));

	}

	@Test
	public void removeAProgramThatDoesNotExist() {
		assertTrue(ndbr.removeAProgram(1).contains(
				TestConstants.NOPROGRAMEXISTS));

	}

	@Test
	public void removeAProgramThatDoesExist() {
		Mockito.when(manager.find(Mockito.any(), Mockito.anyInt())).thenReturn(
				program1);
		assertEquals("{\"message\": \"OITNB removed\"}", ndbr.removeAProgram(1));

	}

	@Test
	public void updateAProgramThatDoesNotExist() {
		assertTrue(ndbr.updateAProgram(1, TestConstants.TEST_UPDATEPROGRAM)
				.contains(TestConstants.NOPROGRAMEXISTS));
	}

	@Test
	public void updateAProgramThatDoesExist() {
		Mockito.when(manager.find(Mockito.any(), Mockito.anyInt())).thenReturn(
				program1);
		assertEquals(TestConstants.TEST_UPDATEPROGRAM,
				ndbr.updateAProgram(1, TestConstants.TEST_UPDATEPROGRAM));
	}

	@Test
	public void getAProgramThatDoesNotExist() {
		assertTrue(ndbr.getAProgram(1).contains(TestConstants.NOPROGRAMEXISTS));
	}

	@Test
	public void getAProgramThatDoesExist() {
		Mockito.when(manager.find(Mockito.any(), Mockito.anyInt())).thenReturn(
				program1);
		assertEquals(TestConstants.TEST_PROGRAM1STR, ndbr.getAProgram(1));
	}

}
