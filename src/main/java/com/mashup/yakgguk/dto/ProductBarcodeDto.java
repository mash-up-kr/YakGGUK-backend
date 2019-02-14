package com.mashup.yakgguk.dto;

import com.mashup.yakgguk.entity.Product;
import com.mashup.yakgguk.entity.ProductBarcode;
import com.mashup.yakgguk.entity.ProductBarcode.BarcodeType;
import com.mashup.yakgguk.entity.ProductLite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductBarcodeDto {

	private ProductLite productLite;
	private BarcodeType barcodeType;
	private int cnt;

	public static ProductBarcodeDto toProductBarcodeDto(Product product, ProductBarcode pb) {
		ProductLite productLite = ProductLite.toProductLite(product);
		return new ProductBarcodeDto(productLite, pb.getBarcodeType(), pb.getCnt());
	}

}
