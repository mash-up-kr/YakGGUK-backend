package com.mashup.yakgguk.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mashup.yakgguk.dto.ProductBarcodeDto;
import com.mashup.yakgguk.entity.Barcode;
import com.mashup.yakgguk.entity.Product;
import com.mashup.yakgguk.entity.ProductBarcode;
import com.mashup.yakgguk.entity.ProductBarcode.BarcodeType;
import com.mashup.yakgguk.exception.NotEnoughProductBarcodeException;
import com.mashup.yakgguk.exception.NotFoundBarcodeException;
import com.mashup.yakgguk.exception.NotFoundProductException;
import com.mashup.yakgguk.repository.BarcodeRepository;
import com.mashup.yakgguk.repository.ProductBarcodeRepository;
import com.mashup.yakgguk.repository.ProductRepository;
import com.mashup.yakgguk.service.BarcodeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BarcodeServiceImplTest {

	@Autowired
	private BarcodeService barcodeService;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private BarcodeRepository barcodeRepository;

	@Autowired
	private ProductBarcodeRepository productBarcodeRepository;

	@Test
	public void test_getProductByBarcodeNumber() {
		String barcodeNumber = "111111";
		Product product = barcodeService.getProductByBarcodeNumber(barcodeNumber);

		assertEquals("test product", product.getName());
	}

	@Test(expected = NotFoundBarcodeException.class)
	public void test_getProduct_NotFoundBarcodeException() {
		String barcodeNumber = "";
		barcodeService.getProductByBarcodeNumber(barcodeNumber);
	}

	@Test(expected = NotEnoughProductBarcodeException.class)
	public void test_getProduct_NotEnoughProductBarcodeException() {
		String barcodeNumber = "222222";
		barcodeService.getProductByBarcodeNumber(barcodeNumber);
	}

	@Test
	public void test_addBarcode() {
		String barcodeNumber = "666666";
		int productId = 52752;
		Barcode barcode = barcodeRepository.findByBarcodeNumber(barcodeNumber).orElse(null);
		ProductBarcode productBarcode = barcode.getProductBarcode().stream()
				.filter(pb -> pb.getProduct().getProductId() == productId).findAny().orElse(null);
		assertEquals(1, productBarcode.getCnt());

		barcodeService.addBarcode(barcodeNumber, productId);

		barcode = barcodeRepository.findByBarcodeNumber(barcodeNumber).orElse(null);
		assertEquals("666666", barcode.getBarcodeNumber());

		productBarcode = barcode.getProductBarcode().stream().filter(pb -> pb.getProduct().getProductId() == productId)
				.findAny().orElse(null);
		assertEquals(2, productBarcode.getCnt());
	}

	@Test(expected = NotFoundProductException.class)
	public void test_addBarcode_NotFoundProductException() {
		String barcodeNumber = "777777";
		int productId = 100000;

		barcodeService.addBarcode(barcodeNumber, productId);
	}

}
