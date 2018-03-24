package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.tqminh.vn.toeicpractice.cache.QuestionListCache;
import com.tqminh.vn.toeicpractice.model.list.MCQuestionList;

public class MCQuestionListCacheImpl implements QuestionListCache<MCQuestionList>{

	private Queue<MCQuestionList> queue= new ConcurrentLinkedQueue<>();

	@Override
	public void addQuestionList(MCQuestionList t) {
		// TODO Auto-generated method stub
	}

	@Override
	public MCQuestionList pollQuestionList() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
