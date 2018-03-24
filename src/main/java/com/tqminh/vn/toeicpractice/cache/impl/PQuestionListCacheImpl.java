package com.tqminh.vn.toeicpractice.cache.impl;

import org.springframework.stereotype.Component;

import com.tqminh.vn.toeicpractice.cache.QuestionListCache;
import com.tqminh.vn.toeicpractice.model.list.PQuestionList;

@Component("PQuestionListCache")
public class PQuestionListCacheImpl implements QuestionListCache<PQuestionList>{

	@Override
	public void putQuestionList(String username, PQuestionList t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PQuestionList getQuestionList(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
