package com.franko.rest.dao;

import java.util.List;

import com.franko.rest.models.Product;

public interface ProductDAO {
	public List<Product> findByName(String name);	
	public boolean enterProduct(Product product);
	public List<Product> getProductDetails();
	public List<Product> getAll();
	public boolean deleteProduct(long id);
}