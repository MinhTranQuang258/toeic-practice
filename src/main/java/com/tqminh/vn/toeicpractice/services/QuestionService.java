package com.tqminh.vn.toeicpractice.services;


import com.tqminh.vn.toeicpractice.model.Question;
import com.tqminh.vn.toeicpractice.repositories.entities.QuestionWrapper;

public interface QuestionService {
	
	String insertQuestion(Question question);
	
	QuestionWrapper loadQuestion(long index);
	
	QuestionWrapper updateQuestion(long id);
	
	QuestionWrapper deleteQuestion(long id);
	
	int countQuestion();
	
	QuestionWrapper nextQuestion();
	
	QuestionWrapper previousQuestion();
}
