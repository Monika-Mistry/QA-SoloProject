package com.bae.util;

import com.bae.persistence.domain.Netflix;

public class TestConstants {

	public static final Netflix TEST_PROGRAM1 = new Netflix(1, "UK", "OITNB", 1);
	public static final String TEST_PROGRAM1STR = "{\"netflixId\":1,\"country\":\"UK\",\"title\":\"OITNB\",\"genreId\":1}";

	public static final Netflix TEST_PROGRAM2 = new Netflix(2, "UK", "Friends",
			2);
	public static final String TEST_PROGRAM2STR = "{\"netflixId\":2,\"country\":\"UK\",\"title\":\"Friends\",\"genreId\":2}";

	public static final String TEST_UPDATEPROGRAM = "{\"netflixId\":1,\"country\":\"USA\",\"title\":\"OITNB\",\"genreId\":1}";

	public static final String NOPROGRAMEXISTS = "Program does not exist";

}
