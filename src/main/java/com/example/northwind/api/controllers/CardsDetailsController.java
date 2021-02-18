package com.example.northwind.api.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.ICardDetailsService;
import com.example.northwind.entities.concretes.CardDetails;
import com.example.northwind.entities.concretes.Customer;

@RestController
@RequestMapping("/api/v1")
public class CardsDetailsController {
	
	@Autowired
	ICardDetailsService cardDetailsService;
	
	@GetMapping("/card_details/{customer_id}")
	public List<CardDetails> getCard(@RequestBody Customer customer) {
		return cardDetailsService.getCard(customer);
	}
	
	@PostMapping("/card_details")
	public CardDetails addToCard(@RequestBody CardDetails cardDetails) {
		return cardDetailsService.addToCard(cardDetails);
	}
	
	@DeleteMapping("/card_details")
	public Map<String, Boolean> removeFromCard(@RequestBody CardDetails cardDetails){
		return cardDetailsService.removeFromCard(cardDetails);
	}
}
