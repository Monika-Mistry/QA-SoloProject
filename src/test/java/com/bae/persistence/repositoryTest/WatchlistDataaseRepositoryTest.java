package com.bae.persistence.repositoryTest;

import javax.persistence.EntityManager;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.WatchlistDatabaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class WatchlistDataaseRepositoryTest {

	@InjectMocks
	private WatchlistDatabaseRepository wdbr;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

}
