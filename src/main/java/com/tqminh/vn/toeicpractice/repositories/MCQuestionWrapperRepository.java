package com.tqminh.vn.toeicpractice.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;

@Transactional
public interface MCQuestionWrapperRepository extends CrudRepository<MCQuestionWrapper, Long>{
	
	@Query(nativeQuery= true, value= Constant.NativeQuery.COUNT_MCQUESTION_BY_ID)
	int countQuestionById();
	
//	@Query(nativeQuery= true, value= "")
//	Long updateQuestionById(long id);
	
	@Query(nativeQuery= true, value= Constant.NativeQuery.FIND_ALL_QUESTION)
	List<MCQuestionWrapper> findAllQuestionList();
	
}
