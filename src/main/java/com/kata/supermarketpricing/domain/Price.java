package com.kata.supermarketpricing.domain;

/**
 * @author Morad MELSAOUI
 *
 */
public class Price {
	
	private final float price;

	public Price(float price) {
		this.price = price;
	}
	
	public double total(float amount) {
		return price * amount;
	}

	public float getPrice() {
		return price;
	}
	
}
