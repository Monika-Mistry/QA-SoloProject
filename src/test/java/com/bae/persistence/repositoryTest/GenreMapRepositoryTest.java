package com.bae.persistence.repositoryTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.repository.GenreMapRepository;
import com.bae.util.JSONUtil;

public class GenreMapRepositoryTest {

	private GenreMapRepository gmr;
	private JSONUtil json;

	@Before
	public void setup() {
		gmr = new GenreMapRepository();
		json = new JSONUtil();
	}

	@Test
	public void returnNoGenresWhenMapEmpty() {
		assertEquals(0, gmr.getGenreMap().size());
		assertEquals("{}", gmr.getAllGenres());
	}

	@Test
	public void returnGenresWhenMapFilled() {
		gmr.getGenreMap().put(1, TestConstants.TEST_GENRE1);

		assertEquals(1, gmr.getGenreMap().size());
		assertEquals(TestConstants.TEST_GENRE1MAP, gmr.getAllGenres());
	}

	@Test
	public void returnGenreWhenItDoesNotExist() {
		assertEquals(TestConstants.GENRENOTEXIST, gmr.getAGenre(1));
	}

	@Test
	public void returnGenreWhenItExists() {
		gmr.getGenreMap().put(1, TestConstants.TEST_GENRE1);

		assertEquals(TestConstants.TEST_GENRE1STR, gmr.getAGenre(1));
	}
}
