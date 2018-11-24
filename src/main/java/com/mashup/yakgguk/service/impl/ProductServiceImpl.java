package com.mashup.yakgguk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mashup.yakgguk.entity.Product;
import com.mashup.yakgguk.repository.ProductRepository;
import com.mashup.yakgguk.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> list(List<String> productNames) {
		

		return null;
	}
	
	private Product searchProduct(String ProductName) { 
//		productRepository.
		
		return null;
	}

	@Override
	public List<Product> parseByName(int barcodeNumber, String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
