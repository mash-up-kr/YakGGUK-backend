package com.mashup.yakgguk.exception;

public class NotFoundProductException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2023541413346331271L;
	
	public NotFoundProductException() {
		super("Not Found Product");
	}

}
