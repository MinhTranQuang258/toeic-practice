package com.tqminh.vn.toeicpractice.services;


import com.tqminh.vn.toeicpractice.model.AbstractQuestion;

public interface QuestionService<T extends AbstractQuestion> {
	
	String insertQuestion(T question);
	
	void updateQuestion(long id, AbstractQuestion question, String username);
	
	void deleteQuestion(long id, String username);
	
	int countQuestion();
	
	int nextQuestion(String username) throws Exception;
	
	int previousQuestion(String username) throws Exception;
	
	T getQuestion(String username, int index) throws Exception;
	
	void validateQuestion(String username, AbstractQuestion question, String selection) throws Exception;
	
	void submit(String username);
	
	T findQuestion(String username, long id);
}
