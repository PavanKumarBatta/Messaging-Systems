package com.cts.controller;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

	
	private final JmsTemplate jmsTemplate;
	
	
	@PostMapping("/id")
	public String placeOrder(@PathVariable int id) {
		
		jmsTemplate.convertAndSend("order.queue","Order Placed: "+id);
		return "Order " + id + " placed!";
	}
}
