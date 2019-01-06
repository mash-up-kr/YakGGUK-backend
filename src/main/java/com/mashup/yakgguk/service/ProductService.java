package com.mashup.yakgguk.service;

import java.util.List;

import com.mashup.yakgguk.dto.ProductLiteDto;
import com.mashup.yakgguk.entity.Product;

public interface ProductService {

	void add(Product product);

	Product getById(int id);

	Product getByName(String name);

	List<Product> searchProducts(String productName);

	ProductLiteDto nameListByNameAndCompany(String name, String company, int pageNo);
}
