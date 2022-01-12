package com.example.service;

import com.example.model.Speaker;
import com.example.repository.HibernateSpeakerRepositoryImpl;
import com.example.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("speakerService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class SpeakerServiceImpl implements SpeakerService {

	private SpeakerRepository speakerRepository;

	@Autowired
	public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
		this.speakerRepository = speakerRepository;
	}

	@Override
	public List<Speaker> findAll() {
		return speakerRepository.findAll();
	}

}
