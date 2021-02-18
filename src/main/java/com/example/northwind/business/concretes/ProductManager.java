package com.example.northwind.business.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.dataaccess.concretes.ProductRepository;
import com.example.northwind.entities.concretes.Product;

@Service
public class ProductManager implements IProductService{
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getById(int id) {
		return productRepository.findById(id);
	}

	@Override
	public Product add(Product product) {
		if(product.getProductName().length() >= 2 
				&& productRepository.findByCategoryId(product.getCategoryId()).size() < 10 ) {
			return productRepository.save(product);
		}
		else if(product.getProductName().length() < 2) {
			System.out.println("Ürün adı en az 2 karakterden oluşmalıdır.");
			return null; 
		}
		else {
			System.out.println("Bu kategoride 10 ürün bulunmaktadır.");
			return null;
		}
	}
	
	@Override
	public ResponseEntity<Product> update(Product product) throws Exception {
		Product productToUpdate = productRepository.findById(product.getId())
				.orElseThrow(()->new Exception("No product with id: " + product.getId()));
		
		productToUpdate.setProductName(product.getProductName());
		
		Product updatedProduct = productRepository.save(productToUpdate);
		
		return ResponseEntity.ok(updatedProduct);
	}
	
	@Override
	public Map<String, Boolean> delete(Product product) throws Exception {
		Product productToDelete = productRepository.findById(product.getId())
				.orElseThrow(()->new Exception("No product with id: " + product.getId()));
		
		productRepository.delete(productToDelete);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Silindi", Boolean.TRUE);
		return response;
	}
}
