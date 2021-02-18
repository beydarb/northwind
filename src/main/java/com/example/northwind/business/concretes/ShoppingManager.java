package com.example.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.IShoppingService;
import com.example.northwind.dataaccess.concretes.CardDetailsRepository;
import com.example.northwind.dataaccess.concretes.OrderDetailsRepository;
import com.example.northwind.dataaccess.concretes.OrderRepository;
import com.example.northwind.entities.concretes.Card;
import com.example.northwind.entities.concretes.CardDetails;
import com.example.northwind.entities.concretes.Order;
import com.example.northwind.entities.concretes.OrderDetails;

@Service
public class ShoppingManager implements IShoppingService{
	@Autowired
	private CardDetailsRepository cardDetailsRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Autowired
	private Order order;
	
	@Autowired 
	private OrderDetails orderDetails;
	
	@Override
	public void buyCard(Card card) {
		//shopping operation
		List<CardDetails> productsToBuy = cardDetailsRepository.findByCustomerId(card.getCustomerId());
		
		//add to order table
		order.setCustomerId(card.getCustomerId());
		orderRepository.save(order); 
		for(CardDetails product:productsToBuy) { 
			//adds each item to order_details table
			orderDetails.setOrderId(order.getOrderId());
			orderDetails.setQuantity(product.getQuantity());
			orderDetails.setProductId(product.getProductId());
			orderDetailsRepository.save(orderDetails);
			
			//deletes the product from customer's card (card_details table)
			cardDetailsRepository.delete(product);
		}
	}
}
