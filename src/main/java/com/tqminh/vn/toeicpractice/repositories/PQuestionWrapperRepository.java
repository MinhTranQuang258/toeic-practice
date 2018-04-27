package com.tqminh.vn.toeicpractice.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.repositories.entities.PQuestionWrapper;

/**
 * The Interface PQuestionWrapperRepository.
 */
@Transactional
public interface PQuestionWrapperRepository
        extends CrudRepository<PQuestionWrapper, Long> {

    /**
     * Count duplicated folder.
     *
     * @param folderName the folder name
     * @return the int
     */
    @Query(nativeQuery = true, value = Constant.NativeQuery.COUNT_DUPLICATED_FOLDER)
    int countDuplicatedFolder(String folderName);

    /**
     * Count question by id.
     *
     * @return the int
     */
    @Query(nativeQuery = true, value = Constant.NativeQuery.COUNT_PQUESTION_BY_ID)
    int countQuestionById();
}
