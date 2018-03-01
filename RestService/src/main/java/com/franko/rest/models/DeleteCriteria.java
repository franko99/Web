package com.franko.rest.models;

import org.hibernate.validator.constraints.NotBlank;

public class DeleteCriteria {

	@NotBlank
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}