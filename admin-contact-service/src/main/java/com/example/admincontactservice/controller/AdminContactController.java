package com.example.admincontactservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Admin")
public class AdminContactController {

	@GetMapping("/Hello")
	public String helloWorld() {
		return "Hello World Admin";
	}
}
