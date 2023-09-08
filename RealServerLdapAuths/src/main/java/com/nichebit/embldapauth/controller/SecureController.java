package com.nichebit.embldapauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

	@GetMapping("/secure")
	public String index() {
		return "Welcome to the home page!";
	}
}
