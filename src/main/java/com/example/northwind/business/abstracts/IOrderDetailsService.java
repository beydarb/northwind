package com.example.northwind.business.abstracts;

import com.example.northwind.entities.concretes.OrderDetails;

public interface IOrderDetailsService {
	OrderDetails add(OrderDetails orderDetail);
}
