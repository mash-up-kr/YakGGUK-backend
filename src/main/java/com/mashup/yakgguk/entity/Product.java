package com.mashup.yakgguk.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.jsoup.nodes.Element;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int productId;

	private String name;

	private int barcodeNumber;

	private String appearance;

	@Column(length = 65535, columnDefinition = "text")
	private String intake;

	private String expirationDate;

	@Column(length = 65535, columnDefinition = "text")
	private String precautions;

	@Column(length = 65535, columnDefinition = "text")
	private String content;

	private String company;

	private LocalDateTime crtDate;

	private LocalDateTime updDate;

	public static Product makeByElement(Element item, LocalDateTime dateTime) {
		String name = item.select("prdlst_nm").text();
		String appearance = item.select("dispos").text();
		String intake = item.select("ntk_mthd").text();
		String expirationDate = item.select("cstdy_mthd").text();
		String precautions = item.select("iftkn_atnt_matr_cn").text();
		String content = item.select("primary_fnclty").text();
		String company = item.select("bssh_nm").text();

		Product product = Product.builder().name(name).appearance(appearance).intake(intake)
				.expirationDate(expirationDate).precautions(precautions).content(content).company(company)
				.crtDate(dateTime).updDate(dateTime).build();

		return product;
	}

}
