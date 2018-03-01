package com.franko.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franko.rest.dao.ProductDAO;
import com.franko.rest.models.Product;
import com.franko.rest.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<Product> findByName(String name) {
		return productDAO.findByName(name);
	}

	@Override
	public boolean enterProduct(Product product) {
		return productDAO.enterProduct(product);
	}

	@Override
	public List<Product> getProductDetails() {
		return productDAO.getProductDetails();
	}

	@Override
	public List<Product> getAll() {
		return productDAO.getAll();
	}

	@Override
	public boolean deleteProduct(long id) {
		return productDAO.deleteProduct(id);
	}
}