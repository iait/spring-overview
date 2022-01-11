package com.example.service;

import com.example.model.Speaker;
import com.example.repository.HibernateSpeakerRepositoryImpl;
import com.example.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

	private SpeakerRepository speakerRepository = new HibernateSpeakerRepositoryImpl();

	@Override
	public List<Speaker> findAll() {
		return speakerRepository.findAll();
	}

}
