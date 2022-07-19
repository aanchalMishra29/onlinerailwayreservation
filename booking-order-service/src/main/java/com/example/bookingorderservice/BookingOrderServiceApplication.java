package com.example.bookingorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class BookingOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingOrderServiceApplication.class, args);
	}

}
