package com.tqminh.vn.toeicpractice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tqminh.vn.toeicpractice.repositories.entities.QuestionWrapper;

@Transactional
public interface QuestionWrapperRepository extends CrudRepository<QuestionWrapper, Long>{
	
	
	@Query(nativeQuery= true, value= "")
	List<QuestionWrapper> findListQuestionByIndex(long startIndex, long endIndex);
}
