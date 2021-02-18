package com.example.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.IOrderService;
import com.example.northwind.dataaccess.concretes.OrderRepository;
import com.example.northwind.entities.concretes.Order;

@Service
public class OrderManager implements IOrderService{
	@Autowired
	private OrderRepository orderRepository;
	@Override
	public Order add(Order order) {
		return orderRepository.save(order);
	}

}
