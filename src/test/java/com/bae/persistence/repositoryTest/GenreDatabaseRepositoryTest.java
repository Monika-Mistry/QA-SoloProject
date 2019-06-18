package com.bae.persistence.repositoryTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.GenreDatabaseRepository;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class GenreDatabaseRepositoryTest {

	@InjectMocks
	private GenreDatabaseRepository gdbr;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil jsonUtil;

}
