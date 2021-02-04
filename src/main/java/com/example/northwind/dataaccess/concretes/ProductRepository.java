package com.example.northwind.dataaccess.concretes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.northwind.entities.concretes.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByCategoryId(int categoryId);
}
