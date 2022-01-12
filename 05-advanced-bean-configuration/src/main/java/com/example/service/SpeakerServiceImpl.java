package com.example.service;

import com.example.model.Speaker;
import com.example.repository.HibernateSpeakerRepositoryImpl;
import com.example.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("speakerService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class SpeakerServiceImpl implements SpeakerService {

	private SpeakerRepository speakerRepository;

	@Autowired
	public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
		System.out.println("calling the constructor");
		this.speakerRepository = speakerRepository;
	}

	@PostConstruct
	public void initialize() {
		System.out.println("calling the initialize method after the constructor");
	}

	@Override
	public List<Speaker> findAll() {
		return speakerRepository.findAll();
	}

}
