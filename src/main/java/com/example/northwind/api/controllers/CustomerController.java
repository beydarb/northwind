package com.example.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.ICustomerService;
import com.example.northwind.entities.concretes.Customer;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	@Autowired
	ICustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAll(){
		return customerService.getAll();
	}
	
	@PostMapping("/customers")
	public Customer add(@RequestBody Customer customer) {
		return customerService.add(customer);
	}
}
