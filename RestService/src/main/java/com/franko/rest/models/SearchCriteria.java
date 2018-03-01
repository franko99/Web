package com.franko.rest.models;

import org.hibernate.validator.constraints.NotBlank;

public class SearchCriteria {
	
	@NotBlank(message = "username can't be empty.")
	String username;
	String password;
	String email;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}