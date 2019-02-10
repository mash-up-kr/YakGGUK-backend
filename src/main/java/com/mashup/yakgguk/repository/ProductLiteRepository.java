package com.mashup.yakgguk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mashup.yakgguk.entity.ProductLite;

public interface ProductLiteRepository extends JpaRepository<ProductLite, Integer> {

	List<ProductLite> findByNameContainingAndCompanyContaining(String name, String company);

}
