package com.franko.rest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franko.rest.models.AjaxResponseBody;
import com.franko.rest.models.DeleteCriteria;
import com.franko.rest.models.EnterProductCriteria;
import com.franko.rest.models.Product;
import com.franko.rest.services.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/api/enterProduct")
	public ResponseEntity<?> enterProduct(@Valid @RequestBody EnterProductCriteria enter, Errors errors) {
		AjaxResponseBody result = new AjaxResponseBody();

		if (errors.hasErrors()) {
			result.setMsg(
					errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
		}

		Product product = new Product();
		product.setName(enter.getName());
		product.setBrand(enter.getBrand());
		product.setWholeSalePrice(enter.getWholeSalePrice());
		product.setSalePrice(enter.getWholeSalePrice() * 2);
		product.setAmount(enter.getAmount());

		boolean insert = productService.enterProduct(product);
		if (insert) {
			result.setMsg("Success");
			List<Product> products = new ArrayList<Product>();
			products.add(product);

			result.setProduct(products);
		} else {
			result.setMsg("Product not inserted.");
		}

		return ResponseEntity.ok(result);
	}

	@PostMapping("/api/deleteProduct")
	public ResponseEntity<?> deleteProduct(@Valid @RequestBody DeleteCriteria id, Errors errors) {
		AjaxResponseBody result = new AjaxResponseBody();

		if (errors.hasErrors()) {
			result.setMsg(
					errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
		}

		boolean deleted = productService.deleteProduct(Long.parseLong(id.getId()));
		if (deleted) {
			result.setMsg("Success");
		} else {
			result.setMsg("Person not deleted.");
		}

		return ResponseEntity.ok(result);
	}
}