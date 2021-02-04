package com.example.northwind.business.abstracts;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.northwind.entities.concretes.Category;

public interface ICategoryService {
	List<Category> getAll();
	Optional<Category> getById(int id);
	Category add(Category category);
	ResponseEntity<Category> update(Category category) throws Exception;
	public Map<String, Boolean> delete(Category category) throws Exception;
	
}
