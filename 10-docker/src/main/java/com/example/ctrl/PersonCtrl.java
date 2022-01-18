package com.example.ctrl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PersonResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/people")
public class PersonCtrl {

	@GetMapping
	public ResponseEntity<List<PersonResponse>> findAll() {

		log.debug("calling get people");
		List<PersonResponse> response = Arrays.asList(
				PersonResponse.builder()
					.name("Juan")
					.age(21)
					.birthDate(LocalDate.of(1990, 12, 30))
					.build(),
				PersonResponse.builder()
					.name("María")
					.age(30)
					.birthDate(LocalDate.of(1985, 1, 21))
					.build());
		return ResponseEntity.ok(response);
	}

}
