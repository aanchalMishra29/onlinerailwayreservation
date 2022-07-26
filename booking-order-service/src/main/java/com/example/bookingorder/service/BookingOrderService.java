package com.example.bookingorder.service;

import org.springframework.beans.factory.annotation.Autowired;
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
		updateSeats(order);
		return  bookingOrderRepository.save(order);
		
	}
	
	public Optional<BookingOrder> getOrderbyId(String id) {
		return bookingOrderRepository.findById(id);
	}
	public void deleteOrder(String id) {
		bookingOrderRepository.deleteById(id);
	}
	public void updateSeats(BookingOrder book) {
		
//		Train train1 = restTemplate.getForObject("http://train-Service/trainById/"+ book.getTrainId(), Train.class);
		Train train=restTemplate.getForObject("http://train-Service/trains/trainById/"+ book.getTrainid(), Train.class);
		System.out.println(book.getTrainid());
		train.setSeats(train.getSeats() - book.getQuantity());
		restTemplate.put("http://train-Service/trains/update/", train);			     
	}
}

