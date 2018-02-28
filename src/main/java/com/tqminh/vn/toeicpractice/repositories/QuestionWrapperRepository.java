package com.tqminh.vn.toeicpractice.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.repositories.entities.QuestionWrapper;

@Transactional
public interface QuestionWrapperRepository extends CrudRepository<QuestionWrapper, Long>{
	
	
	@Query(nativeQuery= true, value= Constant.NativeQuery.FIND_QUESTION_BY_INDEX)
	QuestionWrapper findQuestionByIndex(long Index);
	
	@Query(nativeQuery= true, value= Constant.NativeQuery.FIND_QUESTION_BY_INDEX)
	int countQuestionById();
}
