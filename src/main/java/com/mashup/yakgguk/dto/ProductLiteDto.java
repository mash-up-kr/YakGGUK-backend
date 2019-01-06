package com.mashup.yakgguk.dto;

import java.util.List;

import com.mashup.yakgguk.entity.ProductLite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductLiteDto {
	
	private List<ProductLite> productLites;
	private boolean isLastPage;

}
