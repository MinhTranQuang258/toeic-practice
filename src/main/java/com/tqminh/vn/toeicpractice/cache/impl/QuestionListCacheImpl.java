package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

import com.tqminh.vn.toeicpractice.cache.QuestionListCache;
import com.tqminh.vn.toeicpractice.model.AbstractQuestion;

public class QuestionListCacheImpl implements QuestionListCache<List<AbstractQuestion>>{

	private Queue<List<AbstractQuestion>> queue= new LinkedTransferQueue<>();

	@Override
	public void addQuestionList (List<AbstractQuestion> list) {
		queue.add(list);
	}
	
	@Override
	public List<AbstractQuestion> pollQuestionList(){
		return queue.poll();
	}
}
