package com.bae.persistence.repositoryTest;

import static org.junit.Assert.assertEquals;

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
	
	@Before
	public void setup() {
		ndbr.setManager(manager);
		jsonUtil = new JSONUtil();
		ndbr.setUtil(jsonUtil);
	}
	
	@Test
	public void returnAccountsWhenMapIsFilled() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Netflix> programmes = new ArrayList<Netflix>();
		programmes.add(TestConstants.TEST_PROGRAM1);
		Mockito.when(query.getResultList()).thenReturn(programmes);
		assertEquals(TestConstants.TEST_PROGRAM1LIST, ndbr.getAllProgrammes());
	}
	
	@Test
	public void returnNoAccountsWhenMapEmpty() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Netflix> programmes = new ArrayList<Netflix>();
		Mockito.when(query.getResultList()).thenReturn(programmes);
		assertEquals("[]", ndbr.getAllProgrammes());
	}
	
	@Test
	public void addAProgram() {
		assertEquals(TestConstants.TEST_PROGRAM1STR,ndbr.addAProgram(TestConstants.TEST_PROGRAM1STR));
		
	}
	
	
	

}
