package com.tqminh.vn.toeicpractice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.repositories.entities.ResultWrapper;

/**
 * The Interface ResultWrapperRepository.
 */
@Transactional
public interface ResultWrapperRepository
        extends CrudRepository<ResultWrapper, Long> {

    /**
     * Find result by date and username.
     *
     * @param date the date
     * @param username the username
     * @return the result wrapper
     */
    @Query(nativeQuery = true, value = Constant.NativeQuery.FIND_RESULTS_BY_DATE_AND_USERNAME)
    ResultWrapper findResultByDateAndUsername(String date, String username);

    /**
     * Find results by date.
     *
     * @param date the date
     * @return the list
     */
    @Query(nativeQuery = true, value = Constant.NativeQuery.FIND_RESULTS_BY_DATE)
    List<ResultWrapper> findResultsByDate(String date);

}
