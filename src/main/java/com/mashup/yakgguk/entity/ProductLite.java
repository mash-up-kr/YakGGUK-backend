package com.mashup.yakgguk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductLite {

	@Id
	@Column(name = "id")
	private int productId;
	private String name;
	private String company;
	
	@Override
	public String toString() {
		return "ProductLite [productId=" + productId + ", name=" + name + ", company=" + company + "]";
	}
	
}
