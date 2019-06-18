package com.bae.util;

public class Constants {

	// Method JSON returns
	public static final String PROGRAMNOTEXIST = "{\"message\": \"Program does not exist\"}";
	public static final String PROGRAMEXISTS = "{\"message\": \"Program already exists\"}";
	public static final String PROGRAMADDED = "{\"message\":\"Program added\"}";
	public static final String PROGRAMREMOVED = "{\"message\":\"Program removed\"}";

	// Query
	public static final String GETALLNETFLIXQUERY = "SELECT n FROM Netflix n";
	public static final String GETWATCHLISTQUERY = "SELECT w FROM Watchlist w";
	public static final String GETALLGENREQUERY = "SELECT g FROM Genre g";

	public static final String GENRENOTEXIST = "{\"message\":\"Genre does not exist\"}";

}
