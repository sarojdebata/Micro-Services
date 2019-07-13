package com.sd.spring.resource.dbresource.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sd.spring.dbservice.model.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Integer>{

	List<Quote>  findByUserName(String username);

}
