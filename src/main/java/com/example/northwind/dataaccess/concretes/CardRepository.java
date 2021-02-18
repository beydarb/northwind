package com.example.northwind.dataaccess.concretes;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.northwind.entities.concretes.Card;


public interface CardRepository extends  JpaRepository<Card, Integer>{
	boolean existsByCustomerId(String customerId);
	Card findByCustomerId(String customerId);
}
