package com.example.northwind.business.abstracts;

import java.util.List;
import java.util.Map;

import com.example.northwind.entities.concretes.CardDetails;
import com.example.northwind.entities.concretes.Customer;

public interface ICardDetailsService {
	List<CardDetails> getCard(Customer customer);
	CardDetails addToCard(CardDetails cardDetails);
	public Map<String, Boolean> removeFromCard(CardDetails cardDetails);
}
