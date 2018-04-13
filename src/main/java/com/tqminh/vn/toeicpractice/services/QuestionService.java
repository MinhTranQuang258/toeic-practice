package com.tqminh.vn.toeicpractice.services;

import java.util.List;

import com.tqminh.vn.toeicpractice.model.AbstractQuestion;

public interface QuestionService<T extends AbstractQuestion> {
	
	String insertQuestion(T question);
	
	T updateQuestion(long id);
	
	T deleteQuestion(long id);
	
	int countQuestion();
	
	int nextQuestion(String username) throws Exception;
	
	int previousQuestion(String username) throws Exception;
	
	T getQuestion(String username, int index) throws Exception;
	
	void validateQuestion(String username, AbstractQuestion question, String selection) throws Exception;
	
	void submit(String username);
	
	T findQuestion(String username, long id);
	
	List<T> loadQuestionList(String username);
}
