package com.suresh.SecureBank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.SecureBank.model.Customers;
import com.suresh.SecureBank.repository.CustomerRepository;

@RestController
public class UserRegistration {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("/userRegistration")
	public ResponseEntity<String> userRegistration(@RequestBody Customers user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Customers id = customerRepository.save(user);

		if (id != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User created successfully");
	}

}
