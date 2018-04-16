package com.tqminh.vn.toeicpractice.services;


import java.sql.SQLException;
import java.text.ParseException;

import com.tqminh.vn.toeicpractice.model.AbstractQuestion;

public interface QuestionService<T extends AbstractQuestion> {
	
	String insertQuestion(T question);
	
	void updateQuestion(long id, AbstractQuestion question, String username) throws SQLException;
	
	void deleteQuestion(long id, String username) throws SQLException;
	
	int countQuestion();
	
	int nextQuestion(String username) throws Exception;
	
	int previousQuestion(String username) throws Exception;
	
	T getQuestion(String username, int index) throws Exception;
	
	void validateQuestion(String username, AbstractQuestion question, String selection) throws Exception;
	
	void submit(String username) throws ParseException, SQLException;
	
	T findQuestion(String username, long id);
}
