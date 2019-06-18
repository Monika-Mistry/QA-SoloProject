package com.bae.persistence.repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.repository.NetflixMapRepository;
import com.bae.util.TestConstants;

public class NetflixMapRepositoryTest {

	private NetflixMapRepository nmr;

	@Before
	public void setup() {
		nmr = new NetflixMapRepository();
	}
	
	@After
	public void teardown() {
		nmr.getNetflixMap().clear();
	}

	@Test
	public void returnNoProgrammesWhenMapEmpty() {
		assertEquals(0, nmr.getNetflixMap().size());
		assertEquals(TestConstants.EMPTYMAP, nmr.getAllProgrammes());
	}

	@Test
	public void returnProgrammesWhenMapIsFilled() {
		nmr.getNetflixMap().put(1, TestConstants.TEST_PROGRAM1);

		assertEquals(1, nmr.getNetflixMap().size());
		assertEquals(TestConstants.TEST_PROGRAM1MAP,
				nmr.getAllProgrammes());

	}

	@Test
	public void addAProgram() {
		nmr.addAProgram(TestConstants.TEST_PROGRAM1STR);

		assertEquals(1, nmr.getNetflixMap().size());
		assertTrue(nmr.getNetflixMap().get(1).getTitle().equals("OITNB"));

	}

	@Test
	public void addTwoProgrammes() {
		nmr.addAProgram(TestConstants.TEST_PROGRAM1STR);
		nmr.addAProgram(TestConstants.TEST_PROGRAM2STR);

		assertEquals(2, nmr.getNetflixMap().size());
		assertTrue(nmr.getNetflixMap().get(1).getCountry().equals("UK"));
		assertTrue(nmr.getNetflixMap().get(2).getTitle().equals("Friends"));

	}

	@Test
	public void addAProgramWhenItAlreadyExists() {
		nmr.getNetflixMap().put(1, TestConstants.TEST_PROGRAM1);

		nmr.addAProgram(TestConstants.TEST_PROGRAM1STR);

		if (nmr.getNetflixMap().size() == 2) {
			fail("Added a program which already exists");
		}

		assertEquals(1, nmr.getNetflixMap().size());
	}

	@Test
	public void deleteAProgram() {
		nmr.getNetflixMap().put(1, TestConstants.TEST_PROGRAM1);

		nmr.removeAProgram(1);

		assertEquals(0, nmr.getNetflixMap().size());

	}

	@Test
	public void deleteTwoProgrammes() {
		nmr.getNetflixMap().put(1, TestConstants.TEST_PROGRAM1);
		nmr.getNetflixMap().put(2, TestConstants.TEST_PROGRAM2);

		nmr.removeAProgram(1);
		nmr.removeAProgram(2);

		assertEquals(0, nmr.getNetflixMap().size());

	}

	@Test
	public void removeAProgramWhenItDoesNotExist() {
		assertTrue(nmr.removeAProgram(1)
				.contains(TestConstants.NOPROGRAMEXISTS));
	}

	@Test
	public void updateAProgram() {
		nmr.getNetflixMap().put(1, TestConstants.TEST_PROGRAM1);

		nmr.updateAProgram(1, TestConstants.TEST_UPDATEPROGRAM);

		assertTrue(nmr.getNetflixMap().get(1).getCountry().equals("USA"));
	}

	@Test
	public void getAProgramThatExists() {
		nmr.getNetflixMap().put(1, TestConstants.TEST_PROGRAM1);

		assertTrue(nmr.getAProgram(1).contains("OITNB"));
	}

	@Test
	public void getAProgramThatDoesNotExists() {

		assertTrue(nmr.getAProgram(1).contains(TestConstants.NOPROGRAMEXISTS));
	}
}