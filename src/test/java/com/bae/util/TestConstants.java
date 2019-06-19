package com.bae.util;

import com.bae.persistence.domain.Genre;
import com.bae.persistence.domain.Netflix;
import com.bae.persistence.domain.Watchlist;

public class TestConstants {
	
	//NetflixRepo

	public static final String TEST_PROGRAM1STR = "{\"netflixId\":1,\"country\":\"UK\",\"title\":\"OITNB\",\"genreId\":1}";
	public static final String TEST_PROGRAM1MAP = "{\"1\":{\"netflixId\":1,\"country\":\"UK\",\"title\":\"OITNB\",\"genreId\":1}}";
	public static final String TEST_PROGRAM1LIST = "[{\"netflixId\":1,\"country\":\"UK\",\"title\":\"OITNB\",\"genreId\":1}]";
	public static final String TEST_PROGRAM1TITLE = "{\"message\":\"OITNB\"}";

	public static final Netflix TEST_PROGRAM2 = new Netflix(2, "UK", "Friends",
			2);
	public static final String TEST_PROGRAM2STR = "{\"netflixId\":2,\"country\":\"UK\",\"title\":\"Friends\",\"genreId\":2}";

	public static final String TEST_UPDATEPROGRAM = "{\"netflixId\":1,\"country\":\"USA\",\"title\":\"OITNB\",\"genreId\":1}";
	
	


	//WatchlistRepo
	public static final String TEST_WATCHLIST1STR = "{\"netflixId\":1,\"status\":\"PENDING\"}";
	public static final String TEST_WATCHLIST1LIST = "[{\"netflixId\":1,\"status\":\"PENDING\"}]";

	public static final Watchlist TEST_WATCHLIST2 = new Watchlist(2,
			WatchStatus.COMPLETED);
	public static final String TEST_WATCHLIST2STR = "{\"netflixId\":2,\"status\":\"COMPLETED\"}";

	public static final String TEST_UPDATEWATCHLIST = "{\"netflixId\":1,\"status\":\"INPROGRESS\"}";

	// All
	public static final String EMPTYLIST = "[]";
	public static final String EMPTYMAP = "{}";
	public static final String NOPROGRAMEXISTS = "Program does not exist";
	public static final String PROGRAMEXISTS = "{\"message\": \"Program already exists\"}";

	// GenreRepo
	public static final String GENRENOTEXIST = "{\"message\":\"Genre does not exist\"}";
	public static final String TEST_GENRE1STR = "{\"genreId\":1,\"genreName\":\"Comedy\"}";
	public static final String TEST_GENRE1MAP = "{\"1\":{\"genreId\":1,\"genreName\":\"Comedy\"}}";
	public static final String TEST_GENRE1LIST = "[{\"genreId\":1,\"genreName\":\"Comedy\"}]";
	public static final Genre GENRE1 = new Genre(1, "Comedy");
	
	//WatchStatus String equivalents
	public static final String PENDINGSTR = "PENDING";
	public static final String INPROGRESSSTR = "INPROGRESS";
	public static final String COMPLETESTR = "COMPLETED";


}
