package com.mashup.yakgguk.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mashup.yakgguk.dto.ProductLiteDto;
import com.mashup.yakgguk.entity.Product;
import com.mashup.yakgguk.entity.ProductLite;
import com.mashup.yakgguk.repository.ProductLiteRepository;
import com.mashup.yakgguk.repository.ProductRepository;
import com.mashup.yakgguk.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductLiteRepository productLiteRepository;

	private static final int ONE_PAGE_SIZE = 10;

	@Override
	public Product getById(int id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public ProductLiteDto nameListByNameAndCompany(String name, String company, int pageNo) {
		List<ProductLite> list = productLiteRepository.findByNameContainingAndCompanyContaining(name, company);

		int totalPage = getTotalPage(list.size(), ONE_PAGE_SIZE);
		boolean isLastPage = totalPage == pageNo ? true : false;

		list = sortList(list, name);
		list = list.subList((pageNo - 1) * ONE_PAGE_SIZE, Math.min(pageNo * ONE_PAGE_SIZE, list.size()));

		return new ProductLiteDto(list, isLastPage);
	}

	private List<ProductLite> sortList(List<ProductLite> list, String name) {
		list.sort(Comparator.comparing(ProductLite::getName));

		List<ProductLite> startNameList = list.stream().filter(l -> l.getName().startsWith(name))
				.collect(Collectors.toList());

		// 입력받은 name으로 시작하는 product들을 list앞부분에 위치시키기
		list.removeAll(startNameList);
		startNameList.addAll(list);

		return startNameList;
	}

	private int getTotalPage(int totalSize, int size) {
		int res = totalSize / size;
		if (totalSize % size == 0)
			return res;
		else
			return res + 1;
	}

}
