package com.mashup.yakgguk.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.yakgguk.dto.ProductLiteDto;
import com.mashup.yakgguk.entity.Product;
import com.mashup.yakgguk.service.ProductService;

@Api(description = "약", tags = {"drug"})
@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@ApiOperation(value = "약 검색", notes = "약을 검색한다.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Server Error")

	})
	@GetMapping(value = "")
	public ProductLiteDto getProductsByNameAndCompany(@RequestParam String name,
			@RequestParam(required = false) String company, @RequestParam int pageNo) {
		return productService.nameListByNameAndCompany(name, company, pageNo);
	}

	@ApiOperation(value = "약 정보 상세 조회(미완성)", notes = "약 정보 상세를 조회한다.")
	@GetMapping(value = "{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getById(id);
	}

}
