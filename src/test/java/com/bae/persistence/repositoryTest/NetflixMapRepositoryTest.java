package com.bae.persistence.repositoryTest;

import org.junit.Before;

import com.bae.persistence.repository.NetflixMapRepository;

public class NetflixMapRepositoryTest {

	private NetflixMapRepository nmr;
	private JSONUtil json;

	@Before
	public void setup() {
		nmr = new NetflixMapRepository();
		json = newJSONUtil();
	}
}