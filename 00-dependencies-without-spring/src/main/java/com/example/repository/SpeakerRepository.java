package com.example.repository;

import com.example.model.Speaker;

import java.util.List;

public interface SpeakerRepository {
	List<Speaker> findAll();
}
