package com.bae.business.service;

public interface WatchlistService {
	// C
	public String addAProgram(String program);

	// R
	public String getWatchlist();

	// U
	public String removeAProgram(int id);

	// D
	public String updateWatchStatus(int id, String status);

}
