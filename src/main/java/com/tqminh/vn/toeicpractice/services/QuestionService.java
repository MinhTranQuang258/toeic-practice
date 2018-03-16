package com.tqminh.vn.toeicpractice.services;


import com.tqminh.vn.toeicpractice.model.Question;

public interface QuestionService {
	
	String insertQuestion(Question question);
	
	Question loadQuestion(long index);
	
	Question updateQuestion(long id);
	
	Question deleteQuestion(long id);
	
	int countQuestion();
	
	Question nextQuestion();
	
	Question previousQuestion();
}
