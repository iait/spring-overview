package com.example;

import com.example.service.SpeakerService;
import com.example.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		System.out.println("creating a bean with setter injection");
		SpeakerService setterSpeakerService =
				appContext.getBean("setterSpeakerService", SpeakerService.class);

		System.out.println("creating a bean with constructor injection");
		SpeakerService constructorSpeakerService =
				appContext.getBean("constructorSpeakerService", SpeakerService.class);

		System.out.println("creating an autowired bean");
		SpeakerService autowiredSpeakerService =
				appContext.getBean("autowiredSpeakerService", SpeakerService.class);

		assert setterSpeakerService != constructorSpeakerService
				&& constructorSpeakerService != autowiredSpeakerService
				&& autowiredSpeakerService != setterSpeakerService;

		System.out.println(setterSpeakerService.findAll().get(0).getFirstName());
		System.out.println(constructorSpeakerService.findAll().get(0).getFirstName());
		System.out.println(autowiredSpeakerService.findAll().get(0).getFirstName());
	}

}
