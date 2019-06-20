package com.bae.business.serviceTest;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.service.NetflixServiceImpl;
import com.bae.persistence.repository.NetflixRepository;
import com.bae.util.TestConstants;

@RunWith(MockitoJUnitRunner.class)
public class NetflixServiceImplTest {
	
	@InjectMocks
	private NetflixServiceImpl service;
	
	@Mock
	private NetflixRepository repo;
	

	@Test
	public void getAllProgrammesTestWhenDBEmpty() {
		Mockito.when(repo.getAllProgrammes()).thenReturn(TestConstants.EMPTYLIST);
		assertEquals(TestConstants.EMPTYLIST, service.getAllProgrammes());
	}


	@Test
	public void addProgramTest() {
		Mockito.when(repo.addAProgram(TestConstants.TEST_PROGRAM1STR)).thenReturn(TestConstants.TEST_PROGRAM1STR);
		assertEquals(TestConstants.TEST_PROGRAM1STR, service.addAProgram(TestConstants.TEST_PROGRAM1STR));
	}
	
	@Test
	public void getAProgramThatDoesNotExist() {
		Mockito.when(repo.getAProgram(Mockito.anyInt())).thenReturn(TestConstants.PROGRAMNOTEXIST);
		assertEquals(TestConstants.PROGRAMNOTEXIST, service.getAProgram(1));
	}

}
