package com.example.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;

@RestController
public class UserCtrl {

	@GetMapping("/user")
	public User getUser(
			@RequestParam(value = "firstName", defaultValue = "John") String firstName,
			@RequestParam(value = "lastName", defaultValue = "Doe") String lastName) {

		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAge(20);
		return user;
	}

}
