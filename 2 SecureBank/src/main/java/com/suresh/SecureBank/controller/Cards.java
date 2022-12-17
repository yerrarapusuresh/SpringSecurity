package com.suresh.SecureBank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cards {
	
	@GetMapping("/myCards")
	public String myCards() {
		return "this is my cards";
	}

}
