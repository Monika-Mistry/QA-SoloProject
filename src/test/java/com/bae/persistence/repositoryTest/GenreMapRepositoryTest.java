package com.bae.persistence.repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
		fail("TODO");
	}

	@Test
	public void returnGenreWhenItDoesNotExist() {
		fail("TODO");
	}

	@Test
	public void returnGenreWhenItExists() {
		fail("TODO");
	}
}
