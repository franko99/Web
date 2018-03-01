package com.franko.rest.models;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class EnterProductCriteria {

	@NotBlank(message = "Name can't be empty.")
	String name;
	@NotBlank(message = "Brand can't be empty.")
	String brand;
	@NotNull(message = "WholeSalePrice can't be empty.")
	double wholeSalePrice;
	@NotNull(message = "Amount can't be empty.")
	int amount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getWholeSalePrice() {
		return wholeSalePrice;
	}

	public void setWholeSalePrice(double wholeSalePrice) {
		this.wholeSalePrice = wholeSalePrice;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
}