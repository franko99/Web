package com.franko.rest.models;

import java.util.List;

public class AjaxResponseBody {
	String msg;
	List<User> users;
	List<Person> persons;
	List<Product> products;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public List<Person> getPersons() {
		return persons;
	}
	
	public void setPerson(List<Person> persons) {
		this.persons = persons;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProduct(List<Product> products) {
		this.products = products;
	}
}