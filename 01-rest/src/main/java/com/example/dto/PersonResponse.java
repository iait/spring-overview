package com.example.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonResponse {

	private String name;

	private Integer age;

	private LocalDate birthDate;

}
