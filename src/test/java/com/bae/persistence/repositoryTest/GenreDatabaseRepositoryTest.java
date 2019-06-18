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

import com.bae.persistence.domain.Genre;
import com.bae.persistence.repository.GenreDatabaseRepository;
import com.bae.util.JSONUtil;
import com.bae.util.TestConstants;

@RunWith(MockitoJUnitRunner.class)
public class GenreDatabaseRepositoryTest {

	@InjectMocks
	private GenreDatabaseRepository gdbr;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil jsonUtil;

	@Before
	public void setup() {
		gdbr.setManager(manager);
		jsonUtil = new JSONUtil();
		gdbr.setUtil(jsonUtil);
	}

	@Test
	public void returnAccountsWhenDBEmpty() {
		Mockito.when(manager.createQuery(Mockito.anyString()))
				.thenReturn(query);
		List<Genre> genres = new ArrayList<>();
		genres.add(TestConstants.TEST_GENRE1);
		Mockito.when(query.getResultList()).thenReturn(genres);
		assertEquals(TestConstants.TEST_GENRE1LIST, gdbr.getAllGenres());
	}

	@Test
	public void returnAccountsWhenDBFilled() {
		Mockito.when(manager.createQuery(Mockito.anyString()))
				.thenReturn(query);
		List<Genre> genres = new ArrayList<>();
		Mockito.when(query.getResultList()).thenReturn(genres);
		assertEquals("[]", gdbr.getAllGenres());
	}

	@Test
	public void getAGenreThatDoesNotExist() {
		assertEquals(TestConstants.GENRENOTEXIST, gdbr.getAGenre(1));
	}

	@Test
	public void getAGenreThatDoesExist() {
		Mockito.when(manager.find(Mockito.any(), Mockito.anyInt())).thenReturn(
				TestConstants.TEST_GENRE1);
		assertEquals(TestConstants.TEST_GENRE1STR, gdbr.getAGenre(1));
	}

}
