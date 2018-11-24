package com.mashup.yakgguk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.yakgguk.entity.Keyword;
import com.mashup.yakgguk.exception.NotFoundProductException;
import com.mashup.yakgguk.service.KeywordService;
import com.mashup.yakgguk.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private KeywordService keywordService;

	@GetMapping(value = "/barcode")
	public String getProductByBarcodeNumber(@RequestParam int barcodeNumber) {

		if (true)
			throw new NotFoundProductException();

		return null;
	}

	@GetMapping(value = "/test")
	public void test(@RequestParam String keywordName) {
		System.out.println(keywordName);

		Keyword keyword = keywordService.get(keywordName);
		System.out.println(keyword.getId());
		System.out.println(keyword.getKeywordName());
		System.out.println(keyword.getCrtDate());

		// Keyword keyword =
		// Keyword.builder().keywordName(keywordName).crtDate(LocalDateTime.now()).build();
		// keywordService.add(keyword);
		// keywordService.add(keyword);
	}

	@GetMapping
	public String getProducts(@RequestParam int barcodeNumber, @RequestParam String name) {
		Keyword keyword = keywordService.get(name);

		if (keyword == null) {
			

		}

		return null;
	}

}
