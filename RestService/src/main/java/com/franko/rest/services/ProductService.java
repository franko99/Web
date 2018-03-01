package com.franko.rest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.franko.rest.models.Product;

@Service
public interface ProductService {
	public List<Product> findByName(String name);	
	public boolean enterProduct(Product product);
	public List<Product> getProductDetails();
	public List<Product> getAll();
	public boolean deleteProduct(long id);
}