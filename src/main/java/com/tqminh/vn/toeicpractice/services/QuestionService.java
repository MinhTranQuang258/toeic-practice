package com.tqminh.vn.toeicpractice.services;



public interface QuestionService<T> {
	
	String insertQuestion(T question);
	
	T updateQuestion(long id);
	
	T deleteQuestion(long id);
	
	int countQuestion();
	
	void nextQuestion();
	
	void previousQuestion();
	
	T getQuestion(int index) ;
}
