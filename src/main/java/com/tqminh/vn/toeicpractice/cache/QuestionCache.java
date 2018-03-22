package com.tqminh.vn.toeicpractice.cache;

import com.tqminh.vn.toeicpractice.model.AbstractQuestion;

public interface QuestionCache<T extends AbstractQuestion> {

	void insertQuestion(T question);
	
	T getQuestion(int index);
	
	
}
