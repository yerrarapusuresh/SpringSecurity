package com.suresh.securebank.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@GetMapping("Hello")
	public String hello() {
		return "Hello, World";
	}

}
