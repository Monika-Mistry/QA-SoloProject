package com.bae.persistence.domain;

import javax.persistence.Entity;

import com.bae.util.WatchStatus;

@Entity
public class Watchlist {

	// private int userId; //later functionality
	private int netflixId;
	private WatchStatus status;

	public Watchlist() {

	}

	public Watchlist(int netflixId, WatchStatus status) {
		super();
		this.netflixId = netflixId;
		this.status = status;
	}

	public int getNetflixId() {
		return netflixId;
	}

	public void setNetflixId(int netflixId) {
		this.netflixId = netflixId;
	}

	public WatchStatus getStatus() {
		return status;
	}

	public void setStatus(WatchStatus status) {
		this.status = status;
	}
}
