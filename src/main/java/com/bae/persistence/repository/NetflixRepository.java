package com.bae.persistence.repository;

public interface NetflixRepository {

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
