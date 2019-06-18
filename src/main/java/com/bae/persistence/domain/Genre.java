package com.bae.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genre {

	@Id
	private int genreId;
	private String genre;

	public Genre() {
	}

	public Genre(int genreId, String genre) {
		super();
		this.genreId = genreId;
		this.genre = genre;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
