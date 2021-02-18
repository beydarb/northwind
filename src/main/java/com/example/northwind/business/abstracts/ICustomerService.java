package com.example.northwind.business.abstracts;

import java.util.List;

import com.example.northwind.entities.concretes.Customer;

public interface ICustomerService {
	List<Customer> getAll();
	Customer add(Customer customer);
}
