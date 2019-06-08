package com.bae.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Netflix {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int netflixID;
	@Column(length = 3)
	// 3 letter country code
	private String country;
	@Column(length = 100)
	private String title;
	@Column(length = 2)
	private int genreID;

	public Netflix() {

	}

	public Netflix(int netflixID, String country, String title, int genreID) {
		super();
		this.netflixID = netflixID;
		this.country = country;
		this.title = title;
		this.genreID = genreID;
	}

	public int getNetflixID() {
		return netflixID;
	}

	public void setNetflixID(int netflixID) {
		this.netflixID = netflixID;
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

	public int getGenreID() {
		return genreID;
	}

	public void setGenreID(int genreID) {
		this.genreID = genreID;
	}

}
