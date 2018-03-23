package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.tqminh.vn.toeicpractice.cache.QuestionListCache;
import com.tqminh.vn.toeicpractice.model.QuestionList;

public class QuestionListCacheImpl implements QuestionListCache<QuestionList>{

	private Queue<QuestionList> queue= new ConcurrentLinkedQueue<>();

	@Override
	public void addQuestionList(QuestionList t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public QuestionList pollQuestionList() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
