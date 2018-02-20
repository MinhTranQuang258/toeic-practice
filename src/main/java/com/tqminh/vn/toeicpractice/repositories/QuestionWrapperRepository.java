package com.tqminh.vn.toeicpractice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tqminh.vn.toeicpractice.repositories.entities.QuestionWrapper;

@Transactional
public interface QuestionWrapperRepository extends CrudRepository<QuestionWrapper, Long>{
	
}