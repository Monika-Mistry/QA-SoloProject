package com.bae.business.serviceTest;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.service.NetflixServiceImpl;
import com.bae.persistence.repository.NetflixRepository;
import com.bae.util.TestConstants;

@RunWith(MockitoJUnitRunner.class)
public class NetflixServiceImplTest {
	
	@InjectMocks
	private NetflixServiceImpl service;
	
	@Inject
	private NetflixRepository ndbr;
	
//	@Before
//	public void setup() {
//		service.setRepository(ndbr);
//	}

	@Ignore
	@Test
	public void getAllProgrammesTestWhenDBEmpty() {
		Mockito.when(ndbr.getAllProgrammes()).thenReturn(TestConstants.EMPTYLIST);
		assertEquals(TestConstants.EMPTYLIST, service.getAllProgrammes());
	}
	@Ignore
	@Test
	public void addProgramTest() {
		Mockito.when(ndbr.addAProgram(TestConstants.TEST_PROGRAM1STR)).thenReturn(TestConstants.TEST_PROGRAM1STR);
		assertEquals(TestConstants.TEST_PROGRAM1STR, service.addAProgram(TestConstants.TEST_PROGRAM1STR));
	}

}
