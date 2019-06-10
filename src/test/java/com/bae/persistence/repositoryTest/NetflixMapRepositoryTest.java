package com.bae.persistence.repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

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
		fail("TODO");
	}

	@Test
	public void addAProgram() {
		fail("TODO");
	}

	@Test
	public void addTwoProgrammes() {
		fail("TODO");
	}

	@Test
	public void addAProgramWhenItAlreadyExists() {
		fail("TODO");
	}

	@Test
	public void deleteAProgram() {
		fail("TODO");
	}

	@Test
	public void deleteTwoProgrammes() {
		fail("TODO");
	}

	@Test
	public void removeAProgramWhenItDoesNotExist() {
		fail("TODO");
	}

	@Test
	public void updateAProgram() {
		fail("TODO");
	}

}