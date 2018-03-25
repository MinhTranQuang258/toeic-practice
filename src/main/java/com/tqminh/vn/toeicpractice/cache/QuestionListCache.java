package com.tqminh.vn.toeicpractice.cache;


public interface QuestionListCache<T> {

	void putQuestionList(String username, T t);
	
	T getQuestionList(String username);
	
	T removeQuestionList(String username);
	
	Boolean isCheckUsername(String username);
}
