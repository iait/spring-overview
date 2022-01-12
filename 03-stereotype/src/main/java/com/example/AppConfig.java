package com.example;

import com.example.repository.HibernateSpeakerRepositoryImpl;
import com.example.repository.SpeakerRepository;
import com.example.service.SpeakerService;
import com.example.service.SpeakerServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {

}
