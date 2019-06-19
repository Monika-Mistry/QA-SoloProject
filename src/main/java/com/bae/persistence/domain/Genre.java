package com.bae.persistence.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Genre {

	@Id
	private int genreId;
	private String genre;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "genre_id", referencedColumnName = "genreId")
	private Set<Netflix> netflixList = new HashSet<>();

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
