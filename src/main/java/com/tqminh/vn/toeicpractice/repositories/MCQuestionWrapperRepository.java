package com.tqminh.vn.toeicpractice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;

/**
 * The Interface MCQuestionWrapperRepository.
 */
@Transactional
public interface MCQuestionWrapperRepository
        extends CrudRepository<MCQuestionWrapper, Long> {

    /**
     * Count question by id.
     *
     * @return the int
     */
    @Query(nativeQuery = true, value = Constant.NativeQuery.COUNT_MCQUESTION_BY_ID)
    int countQuestionById();

    /**
     * Find all question list.
     *
     * @return the list
     */
    @Query(nativeQuery = true, value = Constant.NativeQuery.FIND_ALL_QUESTION)
    List<MCQuestionWrapper> findAllQuestionList();

}
