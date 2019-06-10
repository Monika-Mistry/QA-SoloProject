package com.bae.persistence.repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Netflix;
import com.bae.persistence.repository.NetflixMapRepository;
import com.bae.util.JSONUtil;

public class NetflixMapRepositoryTest {

	private NetflixMapRepository nmr;
	private JSONUtil json;

	@Before
	public void setup() {
		nmr = new NetflixMapRepository();
		json = new JSONUtil();
	}

	@Test
	public void returnNoAccountsWhenMapEmpty() {
		assertEquals(0, nmr.getNetflixMap().size());
		assertEquals("{}", nmr.getAllProgrammes());
	}

	@Test
	public void returnAccountsWhenMapIsFilled() {
		Netflix n1 = new Netflix(1, "UK", "OITNB", 1);
		nmr.getNetflixMap().put(1, n1);

		assertEquals(1, nmr.getNetflixMap().size());
		assertEquals(
				"{\"1\":{\"netflixId\":1,\"country\":\"UK\",\"title\":\"OITNB\",\"genreId\":1}}",
				nmr.getAllProgrammes());

	}

	@Test
	public void addAProgram() {
		nmr.addAProgram("{\"netflixId\":1,\"country\":\"UK\",\"title\":\"OITNB\",\"genreId\":1}");

		assertEquals(1, nmr.getNetflixMap().size());
		assertTrue(nmr.getNetflixMap().get(1).getTitle().equals("OITNB"));

	}

	@Test
	public void addTwoProgrammes() {
		nmr.addAProgram("{\"netflixId\":1,\"country\":\"UK\",\"title\":\"OITNB\",\"genreId\":1}");
		nmr.addAProgram("{\"netflixId\":2,\"country\":\"UK\",\"title\":\"Friends\",\"genreId\":2}");

		assertEquals(2, nmr.getNetflixMap().size());
		assertTrue(nmr.getNetflixMap().get(1).getCountry().equals("UK"));
		assertTrue(nmr.getNetflixMap().get(2).getTitle().equals("Friends"));

	}

	@Test
	public void addAProgramWhenItAlreadyExists() {
		fail("TODO");

	}

	@Test
	public void deleteAProgram() {
		Netflix n1 = new Netflix(1, "UK", "OITNB", 1);
		nmr.getNetflixMap().put(1, n1);

		nmr.removeAProgram(1);

		assertEquals(0, nmr.getNetflixMap().size());

	}

	@Test
	public void deleteTwoProgrammes() {
		Netflix n1 = new Netflix(1, "UK", "OITNB", 1);
		Netflix n2 = new Netflix(2, "UK", "Friends", 2);

		nmr.getNetflixMap().put(1, n1);
		nmr.getNetflixMap().put(2, n2);

		nmr.removeAProgram(1);
		nmr.removeAProgram(2);

		assertEquals(0, nmr.getNetflixMap().size());

	}

	@Test
	public void removeAProgramWhenItDoesNotExist() {
		fail("TODO");
	}

	@Test
	public void updateAProgram() {
		Netflix n1 = new Netflix(1, "UK", "OITNB", 1);
		nmr.getNetflixMap().put(1, n1);

		nmr.updateAProgram(1,
				"{\"netflixId\":1,\"country\":\"USA\",\"title\":\"OITNB\",\"genreId\":1}");

		assertTrue(nmr.getNetflixMap().get(1).getCountry().equals("USA"));
	}

}