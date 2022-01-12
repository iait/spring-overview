package com.example;

import com.example.service.SpeakerService;
import com.example.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {

		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		SpeakerService singletonSpeakerService1 = appContext.getBean("singletonSpeakerService", SpeakerService.class);
		SpeakerService singletonSpeakerService2 = appContext.getBean("singletonSpeakerService", SpeakerService.class);
		assert singletonSpeakerService1 == singletonSpeakerService2;

		SpeakerService prototypeSpeakerService1 = appContext.getBean("prototypeSpeakerService", SpeakerService.class);
		SpeakerService prototypeSpeakerService2 = appContext.getBean("prototypeSpeakerService", SpeakerService.class);
		assert prototypeSpeakerService1 != prototypeSpeakerService2
				&& prototypeSpeakerService1 != singletonSpeakerService1;

		System.out.println(prototypeSpeakerService1.findAll().get(0).getFirstName());
	}

}
