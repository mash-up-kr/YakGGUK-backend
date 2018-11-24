package com.mashup.yakgguk.entity;

import java.time.LocalDateTime;

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
@Table(name = "keyword")
@Entity
@Builder
public class Keyword {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "keyword_name")
	private String keywordName;
	
	@Column(name = "crt_date")
	private LocalDateTime crtDate;

}
