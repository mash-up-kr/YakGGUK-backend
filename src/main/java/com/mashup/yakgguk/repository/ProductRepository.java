package com.mashup.yakgguk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mashup.yakgguk.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
