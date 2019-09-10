package com.kata.supermarketpricing.service;

import com.kata.supermarketpricing.domain.Discount;
import com.kata.supermarketpricing.domain.Offer;
import com.kata.supermarketpricing.domain.Product;
import com.kata.supermarketpricing.domain.Unit;
import com.kata.supermarketpricing.exception.BusinessException;

/**
 * @author Morad MELSAOUI
 *
 */
public class PricingService {
	
	/**
     * Methode permet de calcule le prix en fonction 
     * du produit,le nombre des items et la promotion
     *
     * @param product
     * @param count
     * @param discount
     * @return le prix du produit;
     */
	public float getPriceProduct(Product product,float count,Discount discount) throws BusinessException {
		if(product.getTypeunit().equals(Unit.OUNCE))
			count = count / 16 ;
		
		if(count < discount.getCount())
			return product.getPrice().getPrice() * count;
		
		int diff = (int)count/discount.getCount();
		float res = count % discount.getCount();
		return diff * discount.getPrice() + res * product.getPrice().getPrice();
	}
	
	
	/**
     * Methode permet de calcule le nombre des items du produit
     * en fonction du nombre des items et l'offre.
     *
     * @param product
     * @param count
     * @param offer
     * @return le nombre des items du produit;
     */
	
	public int getItemOfferProduct(Product product,int count, Offer offer) throws BusinessException {
		if(product.isOffer())
		{
			if(count < offer.getMinItem() )
				return count;
			
			int offerItem = count/offer.getMinItem();
			int itemCount = count + offerItem * offer.getItemOffer();
			
			return itemCount;
			
		}
		else
		{
			return count;
		}
		
	}
}
