package com.mashup.yakgguk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mashup.yakgguk.entity.Keyword;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Integer>{
	
	Keyword findByKeywordName(String keyword);

}
