package com.tqminh.vn.toeicpractice.cache;


public interface QuestionListCache<T> {

	void addQuestionList(T t);
	
	T pollQuestionList();
}
