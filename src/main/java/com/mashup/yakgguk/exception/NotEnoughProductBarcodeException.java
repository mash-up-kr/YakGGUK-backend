package com.mashup.yakgguk.exception;

public class NotEnoughProductBarcodeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -85533756592096139L;
	
	public NotEnoughProductBarcodeException() {
		super("not enough user barcode data");
	}

}
