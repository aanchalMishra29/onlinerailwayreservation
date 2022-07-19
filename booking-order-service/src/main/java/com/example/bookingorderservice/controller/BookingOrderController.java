package com.example.bookingorderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Orders")
public class BookingOrderController {
	@GetMapping("HelloBooking")
	public String helloWorld() {
		return "Hello World Booking";
	}
}
