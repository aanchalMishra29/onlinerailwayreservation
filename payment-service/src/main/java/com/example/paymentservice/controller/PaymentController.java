package com.example.paymentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Payment")
public class PaymentController {
	@GetMapping("HelloPayment")
	public String helloWorld() {
		return "Hello World Payment";
	}
}
