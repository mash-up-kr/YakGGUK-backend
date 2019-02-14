package com.mashup.yakgguk.exception;

public class NotFoundBarcodeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1719891383628446284L;

	public NotFoundBarcodeException() {
		super("Not Found Barcode");
	}
}
