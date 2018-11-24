package com.mashup.yakgguk.service;

import com.mashup.yakgguk.entity.Keyword;

public interface KeywordService {

	Keyword get(String keyword);

	void add(Keyword keyword);

}
