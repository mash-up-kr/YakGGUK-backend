package com.mashup.yakgguk.service;

import com.mashup.yakgguk.entity.Product;

public interface BarcodeService {
	
	/**
	 * barcodeNumber를 받아서 적절한 Product를 반환
	 * 
	 * @param barcodeNumber
	 * @return 
	 */
	Product getProductByBarcodeNumber(String barcodeNumber);
	
	/**
	 * 사용자가 입력한 Barcode와 선택한 Product를 저장
	 * 
	 * @param barcodeNumber
	 * @param productId
	 */
	void addBarcode(String barcodeNumber, int productId);

}
