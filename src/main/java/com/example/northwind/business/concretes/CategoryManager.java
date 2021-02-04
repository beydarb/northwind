package com.example.northwind.business.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.dataaccess.concretes.CategoryRepository;
import com.example.northwind.entities.concretes.Category;

@Service
public class CategoryManager implements ICategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> getById(int id) {
		return categoryRepository.findById(id);
	}

	@Override
	public Category add(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public ResponseEntity<Category> update(Category category) throws Exception {
		Category categoryToUpdate = categoryRepository.findById(category.getCategoryId())
				.orElseThrow(()->new Exception("No category with id: " + category.getCategoryId()));
		
		categoryToUpdate.setCategoryName(category.getCategoryName());
		
		Category updatedCategory = categoryRepository.save(categoryToUpdate);
		
		return ResponseEntity.ok(updatedCategory);
	}

	@Override
	public Map<String, Boolean> delete(Category category) throws Exception {
		Category categoryToDelete = categoryRepository.findById(category.getCategoryId())
				.orElseThrow(()->new Exception("No category with id: " + category.getCategoryId()));
		
		categoryRepository.delete(categoryToDelete);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Silindi", Boolean.TRUE);
		return response;
	}
	
	

}
