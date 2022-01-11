package com.example;

import com.example.service.SpeakerService;
import com.example.service.SpeakerServiceImpl;

public class Application {

	public static void main(String[] args) {

		SpeakerService speakerService = new SpeakerServiceImpl();

		System.out.println(speakerService.findAll().get(0).getFirstName());
	}

}
