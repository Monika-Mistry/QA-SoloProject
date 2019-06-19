package com.bae.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Netflix {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int netflixId;
	@Column(length = 20)
	private String country;
	@Column(length = 100)
	private String title;
	@Column(length = 2)
	private int genreId;

	// @ManyToOne
	// @JoinColumn(name = "genre", nullable = false)
	// private Genre genre;

	public Netflix() {

	}

	public Netflix(int netflixId, String country, String title, int genreId) {
		super();
		this.netflixId = netflixId;
		this.country = country;
		this.title = title;
		this.genreId = genreId;
	}

	//
	// public Genre getGenre() {
	// return genre;
	// }
	//
	// public void setGenre(Genre genre) {
	// this.genre = genre;
	// }

	public int getNetflixId() {
		return netflixId;
	}

	public void setNetflixId(int netflixId) {
		this.netflixId = netflixId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

}
