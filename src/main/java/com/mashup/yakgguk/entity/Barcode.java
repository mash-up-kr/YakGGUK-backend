package com.mashup.yakgguk.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Barcode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "barcode_id")
	private int barcodeId;
	
	@OneToMany(mappedBy = "barcode")
	private List<ProductBarcode> productBarcode = new ArrayList<>();
	
	private String barcodeNumber;
	private String manageNo;
	private LocalDateTime crtDate;
	private LocalDateTime updDate;

}
