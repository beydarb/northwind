package com.example.northwind.business.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.ICardDetailsService;
import com.example.northwind.dataaccess.concretes.CardDetailsRepository;
import com.example.northwind.dataaccess.concretes.CardRepository;
import com.example.northwind.entities.concretes.CardDetails;
import com.example.northwind.entities.concretes.Customer;

@Service
public class CardDetailsManager implements ICardDetailsService {
	@Autowired
	private CardDetailsRepository cardDetailsRepository;
	
	@Autowired
	private CardRepository cardRepository;
	
	@Override
	public List<CardDetails> getCard(Customer customer) {
		//if such customer exists in details table (i.e. if they add products to their card)
		if(cardDetailsRepository.existsByCustomerId(customer.getCustomerId())) {
			return cardDetailsRepository.findByCustomerId(customer.getCustomerId());
		}
		else {
			System.out.println("No such card details exists for customer with id: " + customer.getCustomerId());
			return null;
		}
	}
	
	@Override
	public CardDetails addToCard(CardDetails cardDetails) {
		//first check if such customer exists in the cards table
		if(cardRepository.existsByCustomerId(cardDetails.getCustomerId())) {
			//then find its products from the card details table
			List<CardDetails> listOfDetails = cardDetailsRepository.findByCustomerId(cardDetails.getCustomerId());
			//if the list is empty, add the product directly
			if(listOfDetails.isEmpty()) {
				//find customer's cardId to make sure that customerId - cardId pairs are also 
				//same in the card_details table
				int cardId = cardRepository.findByCustomerId(cardDetails.getCustomerId()).getCardId();
				cardDetails.setCardId(cardId);
				cardDetails.setQuantity(cardDetails.getQuantity());
				return cardDetailsRepository.save(cardDetails);
			}
			
			//if exists, then check if given product exists
			else {
				for(CardDetails details:listOfDetails) {
					//if product exists, update its quantity by given amount of quantity
					if(details.getProductId() == cardDetails.getProductId()) {
						int currentQuantity = details.getQuantity();
						int quantityToAdd = cardDetails.getQuantity();
						details.setQuantity(currentQuantity + quantityToAdd); 
						cardDetailsRepository.save(details);
						return null;
					}
				}
				//if product does not exist in customer's card, add to table
				int cardId = cardRepository.findByCustomerId(cardDetails.getCustomerId()).getCardId();
				cardDetails.setCardId(cardId);
				return cardDetailsRepository.save(cardDetails);
			}
		}
		else {
			System.out.println("No such customer exists.");
			return null;
		}
	}
	
	@Override
	public Map<String, Boolean> removeFromCard(CardDetails cardDetails){
		//check if card exists in the table
		List<CardDetails> cardToDelete = cardDetailsRepository.findByCustomerId(cardDetails.getCustomerId());
		if(cardToDelete.isEmpty()) {
			Map<String, Boolean> response = new HashMap<>();
			response.put("No such customer exists with id: " + cardDetails.getCustomerId(), Boolean.FALSE);
			return response;
		}
		//if exists, check if product exists in that card
		else {
			boolean doesProductExist = false;
			
			for(CardDetails details:cardToDelete) {
				
				//if product exists, decrease its quantity by given amount
				if(details.getProductId() == cardDetails.getProductId()) {
					doesProductExist = true;
					//if customer has less than the quantity is going to be cancelled (null)
					if(details.getQuantity() < cardDetails.getQuantity()) {
						System.out.println("You don't have this amount of product in your card");
						return null;
					}
					
					else {
						int quantityToDelete = cardDetails.getQuantity();
						int currentQuantity = details.getQuantity();
						details.setQuantity(currentQuantity-quantityToDelete);
	
						//if resulting quantity is 0, remove it from the card
						if(details.getQuantity() == 0) {
							cardDetailsRepository.delete(details);
							Map<String, Boolean> response = new HashMap<>();
							response.put("Product has removed from the card", Boolean.TRUE);
							return response;
						}
						//otherwise, update the amount and keep the product
						else {
							cardDetailsRepository.save(details);
							Map<String, Boolean> response = new HashMap<>();
							response.put("Product has cancelled by amount: " + cardDetails.getQuantity(), Boolean.TRUE);
							return response;
						}
					}
				}
			}
			if(doesProductExist == false) {
				//if none of the above, then no such product exists in that card
				Map<String, Boolean> response = new HashMap<>();
				response.put("No such product exists with id: " + cardDetails.getProductId(), Boolean.FALSE);
				return response;
			}
		}
		return null;
	}
	
}
