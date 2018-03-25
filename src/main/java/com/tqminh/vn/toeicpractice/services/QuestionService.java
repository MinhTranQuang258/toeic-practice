package com.tqminh.vn.toeicpractice.services;

import com.tqminh.vn.toeicpractice.model.AbstractQuestion;

public interface QuestionService<T extends AbstractQuestion> {
	
	String insertQuestion(T question);
	
	T updateQuestion(long id);
	
	T deleteQuestion(long id);
	
	int countQuestion();
	
	int nextQuestion(String username);
	
	int previousQuestion(String username);
	
	T getQuestion(int index) throws Exception;
}
