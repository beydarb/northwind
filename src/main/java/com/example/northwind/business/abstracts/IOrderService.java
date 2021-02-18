package com.example.northwind.business.abstracts;

import com.example.northwind.entities.concretes.Order;

public interface IOrderService {
	Order add(Order order);
}
