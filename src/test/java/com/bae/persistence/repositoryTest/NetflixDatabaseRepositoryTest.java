package com.bae.persistence.repositoryTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.NetflixDatabaseRepository;
import com.bae.util.JSONUtil;

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
	

}
