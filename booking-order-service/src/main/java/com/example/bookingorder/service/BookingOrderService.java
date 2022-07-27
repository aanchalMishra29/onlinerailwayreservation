package com.example.bookingorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.bookingorder.model.BookingOrder;
import com.example.bookingorder.model.Train;
import com.example.bookingorder.repository.BookingOrderRepository;
import java.util.*;

@Service
public class BookingOrderService {
	
	@Autowired
	private BookingOrderRepository bookingOrderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public BookingOrder addOrder (BookingOrder order) {
		Train train=restTemplate.getForObject("http://train-Service/trains/trainById/"+ order.getTrainid(), Train.class);
		if(train!=null && train.getSeats()>order.getQuantity()) {
		updateSeats(order);
		return  bookingOrderRepository.save(order);}
		else {
			return null;
		}
	}
	
	public BookingOrder getOrderbyName(String name) {
		return bookingOrderRepository.findByUserName(name);
	}
	public void deleteOrder(String id) {
		bookingOrderRepository.deleteById(id);
	}
	public void updateSeats(BookingOrder book) {
		
		Train train=restTemplate.getForObject("http://train-Service/trains/trainById/"+ book.getTrainid(), Train.class);
		train.setSeats(train.getSeats() - book.getQuantity());
		restTemplate.put("http://train-Service/trains/update/", train);			     
	}
}

