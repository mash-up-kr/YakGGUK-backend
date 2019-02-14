package com.mashup.yakgguk.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mashup.yakgguk.dto.ProductBarcodeDto;
import com.mashup.yakgguk.entity.ProductBarcode.BarcodeType;
import com.mashup.yakgguk.exception.NotEnoughProductBarcodeException;
import com.mashup.yakgguk.exception.NotFoundBarcodeException;
import com.mashup.yakgguk.service.BarcodeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BarcodeServiceImplTest {

	@Autowired
	private BarcodeService barcodeService;

	@Test
	public void test_getProductByBarcodeNumber() {
		String barcodeNumber = "111111";
		ProductBarcodeDto pbd = barcodeService.getProductByBarcodeNumber(barcodeNumber);

		assertEquals(BarcodeType.OFFICIAL, pbd.getBarcodeType());
		assertEquals(1, pbd.getCnt());
		assertEquals("test product", pbd.getProductLite().getName());
	}

	@Test
	public void test_getProductByBarcodeNumber2() {
		String barcodeNumber = "333333";
		ProductBarcodeDto pbd = barcodeService.getProductByBarcodeNumber(barcodeNumber);

		assertEquals(BarcodeType.USER, pbd.getBarcodeType());
		assertEquals(11, pbd.getCnt());
		assertEquals("test product", pbd.getProductLite().getName());
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

}
