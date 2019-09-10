package com.kata.supermarketpricing.domain;

/**
 * @author Morad MELSAOUI
 *
 */
public class Discount {
	
	private float price;
	private int count;
	
	public Discount(float price,int count)
	{
		this.price = price;
		this.count = count;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
