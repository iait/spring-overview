package com.example.service;

import com.example.model.Speaker;
import com.example.repository.HibernateSpeakerRepositoryImpl;
import com.example.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

	private SpeakerRepository speakerRepository;

	public SpeakerServiceImpl() {
	}

	public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
		System.out.println("calling the constructor");
		this.speakerRepository = speakerRepository;
	}

	public void setSpeakerRepository(SpeakerRepository speakerRepository) {
		System.out.println("calling the speaker repository setter");
		this.speakerRepository = speakerRepository;
	}

	@Override
	public List<Speaker> findAll() {
		return speakerRepository.findAll();
	}

}
