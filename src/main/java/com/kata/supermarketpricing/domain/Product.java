package com.kata.supermarketpricing.domain;

/**
 * @author Morad MELSAOUI
 *
 */
public class Product {
	
	private String name;
	private Price price;
	private Enum<?> typeunit;
	private boolean isOffer;
	
	public Product(String name,Price price, Enum<?> typeunit, boolean isOffer)
	{
		this.name = name;
		this.price = price;
		this.typeunit = typeunit;
		this.isOffer = isOffer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Enum<?> getTypeunit() {
		return typeunit;
	}

	public void setTypeunit(Enum<?> typeunit) {
		this.typeunit = typeunit;
	}

	public boolean isOffer() {
		return isOffer;
	}

	public void setOffer(boolean isOffer) {
		this.isOffer = isOffer;
	}
	
	

}
