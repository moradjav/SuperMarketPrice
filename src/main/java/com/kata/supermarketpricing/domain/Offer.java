package com.kata.supermarketpricing.domain;

/**
 * @author Morad MELSAOUI
 *
 */

public class Offer {
	
	private int minItem;
	private int itemOffer;
	
	public Offer(int minItem,int itemOffer)
	{
		this.minItem = minItem;
		this.itemOffer = itemOffer;
	}

	public int getMinItem() {
		return minItem;
	}

	public void setMinItem(int minItem) {
		this.minItem = minItem;
	}

	public int getItemOffer() {
		return itemOffer;
	}

	public void setItemOffer(int itemOffer) {
		this.itemOffer = itemOffer;
	}

	
}
