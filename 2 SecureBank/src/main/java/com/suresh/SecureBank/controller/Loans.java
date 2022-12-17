package com.suresh.SecureBank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Loans {

	@GetMapping("/myLoans")
	public String myLoans() {
		return "This is my loans";
	}
}
