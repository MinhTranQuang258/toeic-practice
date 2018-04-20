package com.tqminh.vn.toeicpractice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.repositories.entities.ResultWrapper;

@Transactional
public interface ResultWrapperRepository
        extends CrudRepository<ResultWrapper, Long> {

    @Query(nativeQuery = true, value = Constant.NativeQuery.FIND_RESULTS_BY_DATE_AND_USERNAME)
    ResultWrapper findResultByDateAndUsername(String date, String username);

    @Query(nativeQuery = true, value = Constant.NativeQuery.FIND_RESULTS_BY_DATE)
    List<ResultWrapper> findResultsByDate(String date);

}
