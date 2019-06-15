package com.bae.persistence.domain;

import javax.persistence.Entity;

@Entity
public class Watchlist {

	// private int userId; //later functionality
	private int netflixId;
	private WatchStatus status;
}
