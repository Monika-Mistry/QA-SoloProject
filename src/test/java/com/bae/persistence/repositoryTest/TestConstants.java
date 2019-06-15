package com.bae.persistence.repositoryTest;

import com.bae.persistence.domain.Netflix;
import com.bae.persistence.domain.Watchlist;
import com.bae.util.WatchStatus;

public class TestConstants {

	// NetflixRepo
	public static final Netflix TEST_PROGRAM1 = new Netflix(1, "UK", "OITNB", 1);
	public static final String TEST_PROGRAM1STR = "{\"netflixId\":1,\"country\":\"UK\",\"title\":\"OITNB\",\"genreId\":1}";

	public static final Netflix TEST_PROGRAM2 = new Netflix(2, "UK", "Friends",
			2);
	public static final String TEST_PROGRAM2STR = "{\"netflixId\":2,\"country\":\"UK\",\"title\":\"Friends\",\"genreId\":2}";

	public static final String TEST_UPDATEPROGRAM = "{\"netflixId\":1,\"country\":\"USA\",\"title\":\"OITNB\",\"genreId\":1}";

	public static final String NOPROGRAMEXISTS = "Program does not exist";

	// WatchlistRepo
	public static final Watchlist TEST_WATCHLIST1 = new Watchlist(1,
			WatchStatus.PENDING);
	public static final String TEST_WATCHLIST1STR = "{\"netflixId\":1,\"status\":\"PENDING\"}";

	public static final String TEST_WATCHLIST2STR = "{\"netflixId\":2,\"status\":\"COMPLETED\"}";

}
