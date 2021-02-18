package com.example.northwind.business.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.ICardService;
import com.example.northwind.dataaccess.concretes.CardRepository;
import com.example.northwind.entities.concretes.Card;

@Service
public class CardManager implements ICardService {
	@Autowired
	private CardRepository cardRepository;
	
	@Override
	public List<Card> getAll() { //returns all cards in the system 
		return cardRepository.findAll();
	}

	@Override
	public Card add(Card card) {
		//ensures unique customerId - cardId pairs
		if(cardRepository.existsByCustomerId(card.getCustomerId())){
			System.out.println("This customer already has a card.");
			return null;
		}
		else
		{
			return cardRepository.save(card);
		}
			
	}

	@Override
	public Map<String, Boolean> delete(Card card) throws Exception {
		Card cardToDelete = cardRepository.findById(card.getCardId())
				.orElseThrow(()->new Exception("No card with id: " + card.getCardId()));
		
		cardRepository.delete(cardToDelete);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Customer with id: " + card.getCustomerId() + " has deleted.", Boolean.TRUE);
		return response;
		
		
	}

}
