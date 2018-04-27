/*
 * Class: StatisticalServiceImpl
 *
 * Created on Apr 2, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package com.tqminh.vn.toeicpractice.services.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqminh.vn.toeicpractice.cache.AccountCache;
import com.tqminh.vn.toeicpractice.model.Account;
import com.tqminh.vn.toeicpractice.model.Result;
import com.tqminh.vn.toeicpractice.repositories.ResultWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.ResultWrapper;
import com.tqminh.vn.toeicpractice.services.StatisticalService;

@Service("StatisticalService")
public class StatisticalServiceImpl implements StatisticalService {

    @Autowired
    private AccountCache<Account> cache;

    @Autowired
    private ResultWrapperRepository repository;

    @Override
    public int getConcurrentUser() throws SQLException {
        return this.cache.getSize();
    }

    @Override
    public Result getResultByUsername(final String username, final String date)
            throws SQLException {
        ResultWrapper resultWrapper = this.repository
            .findResultByDateAndUsername(date, username);
        if (this.isCheckResult(resultWrapper)) {
            return resultWrapper.getResult();
        }
        else {
            return null;
        }
    }

    @Override
    public List<Result> getTopTenScore(final String date) throws SQLException {
        List<ResultWrapper> lists = this.repository.findResultsByDate(date);
        List<Result> results = new ArrayList<>();
        for (ResultWrapper resultWrapper : lists) {
            results.add(resultWrapper.getResult());
        }
        return results;
    }

    private boolean isCheckResult(final ResultWrapper result) {
        if (result == null) {
            return false;
        }
        else {
            return true;
        }
    }

}