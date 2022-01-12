package com.example;

import com.example.com.example.util.CalendarFactory;
import com.example.repository.HibernateSpeakerRepositoryImpl;
import com.example.repository.SpeakerRepository;
import com.example.service.SpeakerService;
import com.example.service.SpeakerServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Calendar;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {

	@Bean
	public CalendarFactory getCalendarFactory() {
		CalendarFactory calendarFactory = new CalendarFactory();
		calendarFactory.addDays(2);
		return calendarFactory;
	}

}
