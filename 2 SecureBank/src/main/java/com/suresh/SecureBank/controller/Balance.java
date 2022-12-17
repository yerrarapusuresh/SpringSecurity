package com.suresh.SecureBank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Balance {

	@GetMapping("/myBalance")
	public String myBalance() {
		return "This is my balance";
	}
}
