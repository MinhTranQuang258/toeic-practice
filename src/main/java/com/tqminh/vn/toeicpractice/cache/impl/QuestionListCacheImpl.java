/*
 * Class: QuestionListCacheImpl
 *
 * Created on Apr 13, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tqminh.vn.toeicpractice.cache.QuestionListCache;
import com.tqminh.vn.toeicpractice.model.task.AbstractQuestionList;

@Component("QuestionListCacheImpl")
public class QuestionListCacheImpl
        implements QuestionListCache<AbstractQuestionList> {

    private final Map<String, AbstractQuestionList> map;

    public QuestionListCacheImpl() {
        super();
        this.map = new HashMap<>();
    }

    @Override
    public AbstractQuestionList getQuestionList(final String username) {
        return this.map.get(username);
    }

    @Override
    public Boolean isCheckUsername(final String username) {
        return this.map.containsKey(username);
    }

    @Override
    public void putQuestionList(
        final String username,
        final AbstractQuestionList questionList) {
        this.map.put(username, questionList);
    }

    @Override
    public AbstractQuestionList removeQuestionList(final String username) {
        return this.map.remove(username);
    }

}
