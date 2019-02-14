package com.mashup.yakgguk.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class ProductBarcode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_barcode_id")
	private int productBarcodeId;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "barcode_id")
	private Barcode barcode;
	
	@Enumerated(EnumType.STRING)
	private BarcodeType barcodeType;
	
	private int cnt;
	private LocalDateTime crtDate;
	private LocalDateTime updDate;
	
	public static enum BarcodeType {
		OFFICIAL,
		USER
	}
}
