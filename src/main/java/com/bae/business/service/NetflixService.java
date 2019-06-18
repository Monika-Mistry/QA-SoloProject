package com.bae.business.service;

public interface NetflixService {

	// C
	public String addAProgram(String program);

	// R
	public String getAllProgrammes();

	public String getAProgram(int id);

	// U
	public String updateAProgram(int id, String program);

	// D
	public String removeAProgram(int id);

}
