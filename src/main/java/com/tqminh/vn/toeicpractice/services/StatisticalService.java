package com.tqminh.vn.toeicpractice.services;

import java.sql.SQLException;
import java.util.List;

import com.tqminh.vn.toeicpractice.model.Result;

/**
 * The Interface StatisticalService.
 */
public interface StatisticalService {

    /**
     * Gets the concurrent user.
     *
     * @return the concurrent user
     * @throws SQLException the SQL exception
     */
    int getConcurrentUser() throws SQLException;

    /**
     * Gets the result by username.
     *
     * @param username the username
     * @param date the date
     * @return the result by username
     * @throws SQLException the SQL exception
     */
    Result getResultByUsername(String username, String date)
            throws SQLException;

    /**
     * Gets the top ten score.
     *
     * @param date the date
     * @return the top ten score
     * @throws SQLException the SQL exception
     */
    List<Result> getTopTenScore(String date) throws SQLException;
}
