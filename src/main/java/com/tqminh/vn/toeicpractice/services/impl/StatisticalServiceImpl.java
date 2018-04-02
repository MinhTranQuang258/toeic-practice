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

import java.util.List;

import com.tqminh.vn.toeicpractice.cache.AccountCache;
import com.tqminh.vn.toeicpractice.model.Account;
import com.tqminh.vn.toeicpractice.services.StatisticalService;

public class StatisticalServiceImpl implements StatisticalService{

    private AccountCache<Account> cache;
    
    @Override
    public List<Account> getTopTenScore(String date) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getConcurrentUser() {
        return cache.getSize();
    }

}
