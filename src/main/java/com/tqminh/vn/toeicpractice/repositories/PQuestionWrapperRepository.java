package com.tqminh.vn.toeicpractice.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.repositories.entities.PQuestionWrapper;

@Transactional
public interface PQuestionWrapperRepository
        extends CrudRepository<PQuestionWrapper, Long> {

    @Query(nativeQuery = true, value = Constant.NativeQuery.COUNT_DUPLICATED_FOLDER)
    int countDuplicatedFolder(String folderName);

    @Query(nativeQuery = true, value = Constant.NativeQuery.COUNT_PQUESTION_BY_ID)
    int countQuestionById();
}
