package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Registration;

@Controller
public class RegistrationCtrl {

	@GetMapping("registration")
	public String getRegistration(@ModelAttribute("registration") Registration registration) {

		return "registration";
	}

	@PostMapping("registration")
	public String addRegistration(@ModelAttribute("registration") Registration registration) {

		System.out.println("Registration: " + registration.getName());
		return "redirect:registration";
	}

}
