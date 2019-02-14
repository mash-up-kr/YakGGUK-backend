package com.mashup.yakgguk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.yakgguk.dto.ProductBarcodeDto;
import com.mashup.yakgguk.service.BarcodeService;

@RestController
@RequestMapping(value = "/barcodes")
public class BarcodeController {

	@Autowired
	private BarcodeService barcodeService;

	@GetMapping(value = "{barcodeNumber}")
	public ProductBarcodeDto getProductsByNameAndCompany(@PathVariable String barcodeNumber) {
		return barcodeService.getProductByBarcodeNumber(barcodeNumber);
	}

}
