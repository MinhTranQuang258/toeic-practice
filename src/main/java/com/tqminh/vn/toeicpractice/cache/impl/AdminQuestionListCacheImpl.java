/*
 * Class: AdminQuestionListCacheImpl
 *
 * Created on Apr 12, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.LinkedList;
import java.util.List;

import com.tqminh.vn.toeicpractice.cache.QuestionListCache;
import com.tqminh.vn.toeicpractice.model.AbstractQuestion;

public class AdminQuestionListCacheImpl implements QuestionListCache<AbstractQuestion>{

    private List<AbstractQuestion> list= new LinkedList<>();    
    
    @Override
    public void putQuestionList(String username, AbstractQuestion t) {
        
    }

    @Override
    public AbstractQuestion getQuestionList(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AbstractQuestion removeQuestionList(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean isCheckUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
