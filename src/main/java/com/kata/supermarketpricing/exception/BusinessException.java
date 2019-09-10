package com.kata.supermarketpricing.exception;

/**
 * Author Morad MELSAOUI
 * Class exception pour les traitements service
 */
public class BusinessException extends Exception {
	
	
	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {
	      super(message);
	  }

}
