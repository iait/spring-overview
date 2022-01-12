package com.example.repository;

import com.example.model.Speaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("speakerRepository")
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

	@Value("#{ T(java.lang.Math).random() * 100 }")
	private double seedNum;

	@Override
	public List<Speaker> findAll() {

		List<Speaker> speakers = new ArrayList<>();

		Speaker speaker = new Speaker();
		speaker.setFirstName("John");
		speaker.setLastName("Doe");
		speaker.setSeedNum(seedNum);

		speakers.add(speaker);

		return speakers;
	}

}
