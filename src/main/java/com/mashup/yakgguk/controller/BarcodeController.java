package com.mashup.yakgguk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mashup.yakgguk.entity.Product;
import com.mashup.yakgguk.service.BarcodeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "바코드", tags = {"barcode"})
@RestController
@RequestMapping(value = "/barcodes")
public class BarcodeController {

	@Autowired
	private BarcodeService barcodeService;

	@ApiOperation(value = "바코드 번호로 검색", notes = "바코드 번호를 입력하면 제품정보를 준다.")
	@GetMapping(value = "{barcodeNumber}")
	public Product getProductsByNameAndCompany(@PathVariable String barcodeNumber) {
		return barcodeService.getProductByBarcodeNumber(barcodeNumber);
	}

	@ApiOperation(value = "바코드 번호, 제품 데이터 저장", notes = "입력한 바코드 번호와 선택한 제품의 데이터를 저장한다.")
	@PostMapping(value = "")
	public void registerProductBarcode(@RequestParam String barcodeNumber, @RequestParam int productId) {
		barcodeService.addBarcode(barcodeNumber, productId);
	}

}
