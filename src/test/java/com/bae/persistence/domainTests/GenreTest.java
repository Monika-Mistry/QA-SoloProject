package com.bae.persistence.domainTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bae.persistence.domain.Genre;

public class GenreTest {
	
	private Genre genre = new Genre(1, "Comedy");
	
	@Test
	public void getGenreName() {
		assertEquals("Comedy", genre.getGenre());
	}
	
	
	@Test
	public void getGenreId() {
		assertEquals(1, genre.getGenreId());
	}
	
	@Test
	public void createGenre() {
		Genre genre2 = new Genre();
		assertEquals("Genre", genre2.getClass().getSimpleName());
	}
	

}
