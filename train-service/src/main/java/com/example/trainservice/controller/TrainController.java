package com.example.trainservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Trains")
public class TrainController {
	@GetMapping("HelloTrain")
	public String helloWorld() {
		return "Hello World Train";
	}
}
