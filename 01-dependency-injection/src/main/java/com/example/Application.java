package com.example;

import com.example.service.SpeakerService;
import com.example.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		SpeakerService speakerService = applicationContext.getBean("speakerService", SpeakerService.class);

		System.out.println(speakerService.findAll().get(0).getFirstName());
	}

}
