package com.mashup.yakgguk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mashup.yakgguk.entity.Barcode;

public interface BarcodeRepository extends JpaRepository<Barcode, Integer>{
	
	Optional<Barcode> findByBarcodeNumber(String barcodeNumber);
}
