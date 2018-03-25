package com.tqminh.vn.toeicpractice.services;

import com.tqminh.vn.toeicpractice.model.AbstractQuestion;

public interface QuestionService<T extends AbstractQuestion> {
	
	String insertQuestion(T question);
	
	T updateQuestion(long id);
	
	T deleteQuestion(long id);
	
	int countQuestion();
	
	int nextQuestion(String username) throws Exception;
	
	int previousQuestion(String username) throws Exception;
	
	T getQuestion(int index) throws Exception;
	
	void submit();
}
