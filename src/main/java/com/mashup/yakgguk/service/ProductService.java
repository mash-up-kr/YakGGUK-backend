package com.mashup.yakgguk.service;

import com.mashup.yakgguk.dto.ProductLiteDto;
import com.mashup.yakgguk.entity.Product;

public interface ProductService {

	Product getById(int id);

	ProductLiteDto nameListByNameAndCompany(String name, String company, int pageNo);
}
