package com.mashup.yakgguk.service;

import java.util.List;

import com.mashup.yakgguk.entity.Product;

public interface ProductService {
	
	List<Product> list(List<String> productNames);
	
	List<Product> parseByName(int barcodeNumber, String name);

}
