package com.bae.business.serviceTest;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.service.NetflixServiceImpl;
import com.bae.persistence.repository.NetflixDatabaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class NetflixServiceImplTest {
	
	@InjectMocks
	private NetflixServiceImpl service;
	
	@Inject
	private NetflixDatabaseRepository ndbr;
	
	@Before
	public void setup() {
		service.setRepository(ndbr);
	}
	
	@Test
	public void getAllProgrammesTestWhenDBEmpty() {
		
	}

}
