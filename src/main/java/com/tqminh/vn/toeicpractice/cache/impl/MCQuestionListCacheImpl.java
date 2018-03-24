package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.HashMap;
import java.util.Map;


import com.tqminh.vn.toeicpractice.cache.QuestionListCache;
import com.tqminh.vn.toeicpractice.model.list.MCQuestionList;

public class MCQuestionListCacheImpl implements QuestionListCache<MCQuestionList>{

	private Map<String,MCQuestionList> map= new HashMap<>();

	@Override
	public void putQuestionList(String username, MCQuestionList t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MCQuestionList getQuestionList(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
