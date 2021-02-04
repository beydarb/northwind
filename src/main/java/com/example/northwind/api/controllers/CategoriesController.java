package com.example.northwind.api.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.entities.concretes.Category;

@RestController
@RequestMapping("/api/v1")
public class CategoriesController {
	@Autowired
	ICategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> getAll(){
		return categoryService.getAll();
	}
	@GetMapping("/categories/{category_id}")
	public Optional<Category> getById(@PathVariable(value="category_id") int id) {
		return categoryService.getById(id);
	}
	@PostMapping("/categories")
	public Category add(@RequestBody Category category) {
		return categoryService.add(category);
	}
	
	@PutMapping("/categories/{category_id}")
	public ResponseEntity<Category> update(@RequestBody Category category) throws Exception{
		return categoryService.update(category);
	}
	
	@DeleteMapping("/categories")
	public Map<String, Boolean> delete(@RequestBody Category category) throws Exception{
		return categoryService.delete(category);
	}
}
