package com.tqminh.vn.toeicpractice.cache;


public interface QuestionListCache<T> {

	void putQuestionList(String username, T t);
	
	T getQuestionList(String username);
}
