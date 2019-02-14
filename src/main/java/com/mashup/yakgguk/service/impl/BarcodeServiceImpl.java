package com.mashup.yakgguk.service.impl;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

@Service
public class BarcodeServiceImpl implements BarcodeService {

	@Autowired
	private BarcodeRepository barcodeRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductBarcodeRepository productBarcodeRepository;

	private static final int USER_TYPE_MIN_CNT = 10;

	@Override
	@Transactional
	public ProductBarcodeDto getProductByBarcodeNumber(String barcodeNumber) {
		Barcode barcode = barcodeRepository.findByBarcodeNumber(barcodeNumber)
				.orElseThrow(NotFoundBarcodeException::new);

		List<ProductBarcode> pbs = barcode.getProductBarcode();
		ProductBarcode productBarcode = pbs.stream().filter(pb -> BarcodeType.OFFICIAL == pb.getBarcodeType()).findAny()
				.orElse(null);

		// OFFICIAL타입의 Product가 있으면 반환
		if (productBarcode != null) {
			Product product = productBarcode.getProduct();
			return ProductBarcodeDto.toProductBarcodeDto(product, productBarcode);
		}

		productBarcode = pbs.stream().max(Comparator.comparing(ProductBarcode::getCnt)).orElse(null);

		// USER타입의 Product중에 min cnt를 넘지 않으면 예외처리
		if (productBarcode.getCnt() < USER_TYPE_MIN_CNT)
			throw new NotEnoughProductBarcodeException();

		Product product = productBarcode.getProduct();
		return ProductBarcodeDto.toProductBarcodeDto(product, productBarcode);
	}

	@Override
	@Transactional
	public void addBarcode(String barcodeNumber, int productId) {
		Barcode barcode = barcodeRepository.findByBarcodeNumber(barcodeNumber).orElse(null);

		LocalDateTime dateTime = LocalDateTime.now();
		if (barcode == null) {
			barcode = new Barcode();
			barcode.setBarcodeNumber(barcodeNumber);;
			barcode.setCrtDate(dateTime);
			barcode.setUpdDate(dateTime);

			barcodeRepository.save(barcode);
		}

		List<ProductBarcode> pbs = barcode.getProductBarcode();
		ProductBarcode productBarcode = pbs.stream().filter(pb -> pb.getProduct().getProductId() == productId).findAny()
				.orElse(null);

		if (productBarcode == null) {
			Product product = productRepository.findById(productId).orElseThrow(NotFoundProductException::new);

			productBarcode = ProductBarcode.builder().product(product).barcode(barcode).cnt(1)
					.barcodeType(BarcodeType.USER).crtDate(dateTime).updDate(dateTime).build();
		} else {
			int curCnt = productBarcode.getCnt();
			productBarcode.setCnt(curCnt + 1);
			productBarcode.setUpdDate(dateTime);
		}
		productBarcodeRepository.save(productBarcode);
	}

}
