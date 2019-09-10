package com.kata.supermarketpricing.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import com.kata.supermarketpricing.domain.Discount;
import com.kata.supermarketpricing.domain.Offer;
import com.kata.supermarketpricing.domain.Price;
import com.kata.supermarketpricing.domain.Product;
import com.kata.supermarketpricing.domain.Unit;
import com.kata.supermarketpricing.exception.BusinessException;

public class PricingServiceTest {
	
	private Discount discountCount;
	private Discount discountPound;
	private Offer offerItem;
	private Offer offerItemCas2;
	private Price priceCout;
	private Price pricePount;
	PricingService pricingService ;
	List<Discount> listDiscount = new ArrayList<Discount>() ;
	
	@Before
    public void setUp() throws Exception {
		priceCout = new Price(0.65f);
		pricePount = new Price(1.99f);
		discountCount = new Discount(1f, 3);
		discountPound = new Discount(2.5f, 3);
		
		offerItem = new Offer(2, 1);
		offerItemCas2 = new Offer(3, 2);
		pricingService = new PricingService();
    }
	
	@Test
	public void getPriceProductForCount() throws BusinessException
	{
		Product product = new Product("P1", priceCout, Unit.COUNT,false);
		
		assertEquals("le prix pour un seul produit",0.65f, pricingService.getPriceProduct(product,1,discountCount), Double.MIN_VALUE);
		
		assertEquals("le prix d'un produit en 3 item : Appliquer la promotion",1f, pricingService.getPriceProduct(product,3,discountCount), Double.MIN_VALUE);
		
		assertEquals("le prix d'un produit en 5 item : Appliquer la promotion",2.3f, pricingService.getPriceProduct(product,5,discountCount), Double.MIN_VALUE);
		
	}
	
	@Test
	public void getPriceProductForPoundAndOunce() throws BusinessException
	{
		Product product = new Product("P2", pricePount , Unit.POUND,false);
		
		Product productOunce = new Product("P2", pricePount , Unit.OUNCE,false);
		
		assertEquals(1.99f, pricingService.getPriceProduct(product,1,discountPound), Double.MIN_VALUE);
		
		assertEquals("4 ounces qui vaut 0,25 pounds",1.99f/4, pricingService.getPriceProduct(productOunce,4,discountPound), Double.MIN_VALUE);
		
		assertEquals("48 ounces qui vaut 3 pounds : Appliquer la promotion pour 3 pounds = 2.5f",2.5f,
				pricingService.getPriceProduct(productOunce,48,discountPound), Double.MIN_VALUE);
	}
	
	@Test
	public void getProductOffer() throws BusinessException{
		
		Product productOffer = new Product("P1", priceCout, Unit.COUNT, true);
		
		assertEquals("le prix d'un produit en 2 items : Appliquer l'offre 2 = 3",3, pricingService.getItemOfferProduct(productOffer,2,offerItem), Double.MIN_VALUE);
		
		assertEquals("le prix d'un produit en 4 items : Appliquer l'offre 3 = 5",6, pricingService.getItemOfferProduct(productOffer,4,offerItemCas2), Double.MIN_VALUE);
		
		
	}
	
}
