package com.example.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.IOrderDetailsService;
import com.example.northwind.dataaccess.concretes.OrderDetailsRepository;
import com.example.northwind.entities.concretes.OrderDetails;

@Service
public class OrderDetailsManager implements IOrderDetailsService{
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Override
	public OrderDetails add(OrderDetails orderDetail) {
		return orderDetailsRepository.save(orderDetail);
	}
}
