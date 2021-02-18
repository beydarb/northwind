package com.example.northwind.business.abstracts;

import java.util.List;
import java.util.Map;

import com.example.northwind.entities.concretes.Card;

public interface ICardService {
	List<Card> getAll();
	Card add(Card card);
	public Map<String, Boolean> delete(Card card) throws Exception;
}
