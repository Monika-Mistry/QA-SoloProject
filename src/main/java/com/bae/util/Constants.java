package com.bae.util;

public class Constants {

	// Method JSON returns
	public static final String PROGRAMNOTEXIST = "{\"message\": \"Program does not exist\"}";
	public static final String PROGRAMEXISTS = "{\"message\": \"Program already exists\"}";
	public static final String PROGRAMADDED = "{\"message\":\"Program added\"}";
	public static final String PROGRAMREMOVED = "{\"message\":\"Program removed\"}";

	// Query
	public static final String GETALLNETFLIXQUERY = "SELECT n FROM Netflix n";
	public static final String GETALLWATCHLISTQUERY = "SELECT w FROM Watchlist w";

}
