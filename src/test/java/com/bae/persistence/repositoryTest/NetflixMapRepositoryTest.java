package com.bae.persistence.repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.repository.NetflixMapRepository;

public class NetflixMapRepositoryTest {

	private NetflixMapRepository nmr;

	@Before
	public void setup() {
		nmr = new NetflixMapRepository();
	}

	@Test
	public void returnNoAccountsWhenMapEmpty() {
		assertEquals(0, nmr.getNetflixMap().size());
		assertEquals("{}", nmr.getAllProgrammes());
	}

	@Test
	public void returnAccountsWhenMapIsFilled() {
		nmr.getNetflixMap().put(1, Constants.TEST_PROGRAM1);

		assertEquals(1, nmr.getNetflixMap().size());
		assertEquals("{\"1\":" + Constants.TEST_PROGRAM1STR + "}",
				nmr.getAllProgrammes());

	}

	@Test
	public void addAProgram() {
		nmr.addAProgram(Constants.TEST_PROGRAM1STR);

		assertEquals(1, nmr.getNetflixMap().size());
		assertTrue(nmr.getNetflixMap().get(1).getTitle().equals("OITNB"));

	}

	@Test
	public void addTwoProgrammes() {
		nmr.addAProgram(Constants.TEST_PROGRAM1STR);
		nmr.addAProgram(Constants.TEST_PROGRAM2STR);

		assertEquals(2, nmr.getNetflixMap().size());
		assertTrue(nmr.getNetflixMap().get(1).getCountry().equals("UK"));
		assertTrue(nmr.getNetflixMap().get(2).getTitle().equals("Friends"));

	}

	@Test
	public void addAProgramWhenItAlreadyExists() {
		nmr.getNetflixMap().put(1, Constants.TEST_PROGRAM1);

		nmr.addAProgram(Constants.TEST_PROGRAM1STR);

		if (nmr.getNetflixMap().size() == 2) {
			fail("Added a program which already exists");
		}

		assertEquals(1, nmr.getNetflixMap().size());
	}

	@Test
	public void deleteAProgram() {
		nmr.getNetflixMap().put(1, Constants.TEST_PROGRAM1);

		nmr.removeAProgram(1);

		assertEquals(0, nmr.getNetflixMap().size());

	}

	@Test
	public void deleteTwoProgrammes() {
		nmr.getNetflixMap().put(1, Constants.TEST_PROGRAM1);
		nmr.getNetflixMap().put(2, Constants.TEST_PROGRAM2);

		nmr.removeAProgram(1);
		nmr.removeAProgram(2);

		assertEquals(0, nmr.getNetflixMap().size());

	}

	@Test
	public void removeAProgramWhenItDoesNotExist() {
		assertTrue(nmr.removeAProgram(1).contains(Constants.NOPROGRAMEXISTS));
	}

	@Test
	public void updateAProgram() {
		nmr.getNetflixMap().put(1, Constants.TEST_PROGRAM1);

		nmr.updateAProgram(1, Constants.TEST_UPDATEPROGRAM);

		assertTrue(nmr.getNetflixMap().get(1).getCountry().equals("USA"));
	}

	@Test
	public void getAProgramThatExists() {
		nmr.getNetflixMap().put(1, Constants.TEST_PROGRAM1);

		assertTrue(nmr.getAProgram(1).contains("OITNB"));
	}

	@Test
	public void getAProgramThatDoesNotExists() {

		assertTrue(nmr.getAProgram(1).contains(Constants.NOPROGRAMEXISTS));
	}
}