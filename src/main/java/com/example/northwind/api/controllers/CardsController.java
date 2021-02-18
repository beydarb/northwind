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

import com.example.northwind.business.abstracts.ICardService;
import com.example.northwind.entities.concretes.Card;

@RestController
@RequestMapping("/api/v1")
public class CardsController {
	
	@Autowired
	ICardService cardService;
	
	@GetMapping("/cards")
	public List<Card> getAll(){
		return cardService.getAll();
	}
	
	@PostMapping("/cards")
	public Card add(@RequestBody Card card) {
		return cardService.add(card);
	}
	
	@DeleteMapping("/cards")
	public Map<String, Boolean> delete(@RequestBody Card card) throws Exception{
		return cardService.delete(card);
	}
	
}
