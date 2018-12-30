package com.mashup.yakgguk.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mashup.yakgguk.entity.Product;
import com.mashup.yakgguk.repository.ProductRepository;
import com.mashup.yakgguk.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void add(Product product) {
		productRepository.save(product);
	}
	
	@Override
	public Product getById(int id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product getByName(String name) {
		return productRepository.findByName(name);
	}

}
