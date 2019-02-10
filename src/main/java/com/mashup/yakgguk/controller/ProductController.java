package com.mashup.yakgguk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.yakgguk.dto.ProductLiteDto;
import com.mashup.yakgguk.entity.Product;
import com.mashup.yakgguk.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "")
	public ProductLiteDto getProductsByNameAndCompany(@RequestParam String name,
			@RequestParam(required = false) String company, @RequestParam int pageNo) {
		return productService.nameListByNameAndCompany(name, company, pageNo);
	}
	
	@GetMapping(value = "{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getById(id);
	}

}
