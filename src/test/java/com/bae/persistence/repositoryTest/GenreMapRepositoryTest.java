package com.bae.persistence.repositoryTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Genre;
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
		Genre genre = new Genre(1, "Comedy");
		gmr.getGenreMap().put(1, genre);

		assertEquals(1, gmr.getGenreMap().size());
		assertEquals("{\"1\":{\"genreId\":1,\"genre\":\"Comedy\"}}",
				gmr.getAllGenres());
	}

	@Test
	public void returnGenreWhenItDoesNotExist() {
		assertEquals(TestConstants.GENRENOTEXIST, gmr.getAGenre(1));
	}

	@Test
	public void returnGenreWhenItExists() {
		Genre genre = new Genre(1, "Comedy");
		gmr.getGenreMap().put(1, genre);

		assertEquals("{\"genreId\":1,\"genre\":\"Comedy\"}", gmr.getAGenre(1));
	}
}
