package com.suresh.SecureBank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Accounts {
	
	@GetMapping("/myAccount")
	public String myAccounts() {
		return "This is my accounts page";
	}

}
