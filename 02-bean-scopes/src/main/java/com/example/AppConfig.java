package com.example;

import com.example.repository.HibernateSpeakerRepositoryImpl;
import com.example.repository.SpeakerRepository;
import com.example.service.SpeakerService;
import com.example.service.SpeakerServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean(name = "singletonSpeakerService")
	@Scope(BeanDefinition.SCOPE_SINGLETON)
	public SpeakerService getSingletonSpeakerService() {
		return getSpeakerService();
	}

	@Bean(name = "prototypeSpeakerService")
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public SpeakerService getPrototypeSpeakerService() {
		return getSpeakerService();
	}

	private SpeakerService getSpeakerService() {
		SpeakerServiceImpl speakerService = new SpeakerServiceImpl();
		speakerService.setSpeakerRepository(getSpeakerRepository());
		return speakerService;
	}

	@Bean(name = "speakerRepository")
	public SpeakerRepository getSpeakerRepository() {
		return new HibernateSpeakerRepositoryImpl();
	}

}
