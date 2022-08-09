package com.example.bookingorder.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookingorder.model.BookingOrder;
import com.example.bookingorder.model.MailRequest;
import com.example.bookingorder.model.MailResponse;
import com.example.bookingorder.service.BookingOrderService;
import com.example.bookingorder.service.EmailService;
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("orders")
public class BookingOrderController {
	@Autowired
	private BookingOrderService bookingOrderService;
	


	Logger logger= org.slf4j.LoggerFactory.getLogger(BookingOrderController.class);

	@PostMapping("addorder")
	public String saveOrder(@Valid @RequestBody BookingOrder order) {
	BookingOrder BookingOrder=	bookingOrderService.addOrder(order);
	if(BookingOrder!=null) {
	logger.info("-----------------------Ticket Booked-------------------");
	bookingOrderService.sendEmail(order);
	return "Booked ticket with id :  " + order.getId();}
	else {
		logger.info("-----------------------There is some problem in ticket booking-------------------");
		return "Please try for another train";
	}
    }
	@GetMapping("getorder/{id}")
	public Optional<BookingOrder> getOrder(@PathVariable String id){
		logger.info("-----------------------Ticket Details by entering ticket id-------------------");
		return  bookingOrderService.getOrder(id);
	}
	@GetMapping("getorderbyname/{userName}")
	public List<BookingOrder> getOrderByName(@PathVariable String userName){
		logger.info("-----------------------Ticket Details by entering Username-------------------");
		return  bookingOrderService.findOrderByName(userName);
	}
	 @DeleteMapping("del/{id}")
	 public String deleteOrder (@PathVariable String id) {
		 bookingOrderService.deleteOrder(id);
		logger.info("-----------------------Ticket Booking canceled-------------------");
		return "Your Booking canceled with ticket id "+id;
		}

	}
