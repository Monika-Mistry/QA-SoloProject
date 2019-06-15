package com.bae.persistence.domain;

import javax.persistence.Entity;

@Entity
public class Watchlist {

	private int netflixId;
	private WatchStatus status;
}
