package com.tqminh.vn.toeicpractice.cache;


import com.tqminh.vn.toeicpractice.model.Question;

public interface QuestionCache<T> {

	void insertQuestion(Question question);
	
}
