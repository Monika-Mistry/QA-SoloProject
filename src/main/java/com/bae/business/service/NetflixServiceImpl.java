package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.NetflixRepository;

public class NetflixServiceImpl implements NetflixService {

	@Inject
	private NetflixRepository netflixRepository;

	public String addAProgram(String program) {
		return netflixRepository.addAProgram(program);
	}

	public String getAllProgrammes() {
		return netflixRepository.getAllProgrammes();
	}

	public String getAProgram(int id) {
		return netflixRepository.getAProgram(id);
	}

	public String updateAProgram(int id, String program) {
		return netflixRepository.updateAProgram(id, program);
	}

	public String removeAProgram(int id) {
		return netflixRepository.removeAProgram(id);
	}

	public void setRepository(NetflixRepository repository) {
		this.netflixRepository = repository;
		
	}

}
