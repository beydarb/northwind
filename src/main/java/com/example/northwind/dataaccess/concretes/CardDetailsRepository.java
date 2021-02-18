package com.example.northwind.dataaccess.concretes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.northwind.entities.concretes.CardDetails;

public interface CardDetailsRepository extends JpaRepository<CardDetails, Integer> {
	List<CardDetails> findByCardId(int cardId);
	List<CardDetails> findByCustomerId(String string);
	boolean existsByCustomerId(String string);
}
