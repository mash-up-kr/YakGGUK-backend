package com.mashup.yakgguk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mashup.yakgguk.entity.Keyword;
import com.mashup.yakgguk.repository.KeywordRepository;
import com.mashup.yakgguk.service.KeywordService;

@Service
public class KeywordServiceImpl implements KeywordService {

	@Autowired
	KeywordRepository keywordRepository;

	@Override
	public Keyword get(String keyword) {
		return keywordRepository.findByKeywordName(keyword);
	}

	@Override
	public void add(Keyword keyword) {
		keywordRepository.save(keyword);
	}

}
