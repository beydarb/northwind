package com.example.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.northwind.business.abstracts.IShoppingService;
import com.example.northwind.entities.concretes.Card;

@RestController
@RequestMapping("/api/v1")
public class ShoppingController {
	@Autowired
	IShoppingService shoppingService;

	@GetMapping("/shopping")
	public void buyCard(@RequestBody Card cardDetails) {
		shoppingService.buyCard(cardDetails);
	}
	
}
