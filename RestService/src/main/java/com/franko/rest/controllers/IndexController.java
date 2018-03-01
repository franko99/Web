package com.franko.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.franko.rest.models.Person;
import com.franko.rest.models.Product;
import com.franko.rest.services.PersonService;
import com.franko.rest.services.ProductService;

@Controller
public class IndexController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/ajax", method = RequestMethod.GET)
	public String ajax(@RequestParam(value = "name", required = false, defaultValue = "Frank") String name,
			Model model) {
		model.addAttribute("name", name);
		return "ajax";
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String person(Model model) {
		List<Person> all = personService.getAll();
		if (all.size() > 0) {
			model.addAttribute("persons", all);
		}
		return "person";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "test";
	}
	
	@RequestMapping(value = "/listProduct", method = RequestMethod.GET)
	public String listProduct(Model model) {
		List<Product> all = productService.getAll();
		if (all.size() > 0) {
			model.addAttribute("products", all);
		}
		return "product/listProduct";
	}
	
	@RequestMapping(value = "/enterProduct", method = RequestMethod.GET)
	public String enterProduct(Model model) {
		return "product/enterProduct";
	}
}