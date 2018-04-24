package com.tqminh.vn.toeicpractice.services;

import java.sql.SQLException;
import java.util.List;

import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;

/**
 * The Interface QuestionWrapperService.
 */
public interface QuestionWrapperService {

    /**
     * Find all the question warrapers.
     *
     * @param username the username
     * @return the list
     * @throws NullPointerException the null pointer exception
     * @throws SQLException the SQL exception
     */
    List<MCQuestionWrapper> findAllQuestionWarraper(String username)
            throws NullPointerException, SQLException;

}
