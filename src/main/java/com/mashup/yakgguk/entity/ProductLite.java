package com.mashup.yakgguk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "product")
public class ProductLite {

	@Id
	@Column(name = "product_id")
	private int productId;
	private String name;
	private String company;
	
}
