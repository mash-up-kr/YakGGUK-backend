package com.mashup.yakgguk.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.jsoup.nodes.Element;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;

	private String name;

	private String appearance;

	@Column(length = 65535, columnDefinition = "text")
	private String intake;

	private String expirationDate;

	@Column(length = 65535, columnDefinition = "text")
	private String precautions;

	@Column(length = 65535, columnDefinition = "text")
	private String content;

	private String company;

	private String manageNo;

	private LocalDateTime crtDate;

	private LocalDateTime updDate;

	public Product(String name, String appearance, String intake, String expirationDate,
			String precautions, String content, String company, String manageNo) {
		super();
		this.name = name;
		this.appearance = appearance;
		this.intake = intake;
		this.expirationDate = expirationDate;
		this.precautions = precautions;
		this.content = content;
		this.company = company;
		this.manageNo = manageNo;
	}

	public static Product makeByElement(Element item, LocalDateTime dateTime) {
		String name = item.select("prdlst_nm").text();
		String appearance = item.select("dispos").text();
		String intake = item.select("ntk_mthd").text();
		String expirationDate = item.select("cstdy_mthd").text();
		String precautions = item.select("iftkn_atnt_matr_cn").text();
		String content = item.select("primary_fnclty").text();
		String company = item.select("bssh_nm").text();
		String manageNo = item.select("gu_prdlst_mnf_manage_no").text();

		return new Product(name, appearance, intake, expirationDate, precautions, content, company, manageNo);
	}

}
