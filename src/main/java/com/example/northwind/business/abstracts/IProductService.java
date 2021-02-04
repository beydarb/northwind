package com.example.northwind.business.abstracts;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.northwind.entities.concretes.Product;

public interface IProductService {
	List<Product> getAll();
	Optional<Product> getById(int id);
	Product add(Product product);
	ResponseEntity<Product> update(Product product) throws Exception;
	public Map<String, Boolean> delete(Product product) throws Exception;
}
