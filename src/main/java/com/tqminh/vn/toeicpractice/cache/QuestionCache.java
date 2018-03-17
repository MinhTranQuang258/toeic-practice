package com.tqminh.vn.toeicpractice.cache;


import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;

public interface QuestionCache<T> {

	void insertQuestion(MultipleChoiceQuestion question);
	
	T getQuestion(int index);
	
	
}
