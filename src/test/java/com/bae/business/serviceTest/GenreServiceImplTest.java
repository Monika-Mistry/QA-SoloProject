package com.bae.business.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.service.GenreServiceImpl;
import com.bae.persistence.repository.GenreRepository;
import com.bae.util.TestConstants;

@RunWith(MockitoJUnitRunner.class)
public class GenreServiceImplTest {

	@InjectMocks
	private GenreServiceImpl service;
	
	@Mock
	private GenreRepository repo;
	
	@Test
	public void getAGenreThatDoesNotExist() {
		Mockito.when(repo.getAGenre(Mockito.anyInt())).thenReturn(TestConstants.GENRENOTEXIST);
		assertEquals(TestConstants.GENRENOTEXIST, service.getAGenre(1));
	}
	
	@Test
	public void getGenresWhenDBEmpty() {
		Mockito.when(repo.getAllGenres()).thenReturn(TestConstants.EMPTYLIST);
		assertEquals(TestConstants.EMPTYLIST, service.getAllGenres());
	}
	
	
}
