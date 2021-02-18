package com.example.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.IOrderDetailsService;
import com.example.northwind.entities.concretes.OrderDetails;

@RestController
@RequestMapping("/api/v1")
public class OrdersDetailsController {
	@Autowired
	IOrderDetailsService orderDetailsService;
	
	@PostMapping("/order_details")
	public OrderDetails add(@RequestBody OrderDetails orderDetails) {
		return orderDetailsService.add(orderDetails);
	}
}
