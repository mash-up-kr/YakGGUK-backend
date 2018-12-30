package com.mashup.yakgguk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int productId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "barcode_number")
	private int barcodeNumber;
	
	@Column(name = "appearance")
	private String appearance;
	
	@Column(name = "intake")
	private String intake;
	
	@Column(name = "expiration_date")
	private String expirationDate;
	
	@Column(name = "precautions")
	private String precautions;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "company")
	private String company;

}
