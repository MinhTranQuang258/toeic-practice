package com.tqminh.vn.toeicpractice.services;

import java.util.List;

import com.tqminh.vn.toeicpractice.model.Question;
import com.tqminh.vn.toeicpractice.repositories.entities.QuestionWrapper;

public interface QuestionService {
	
	String insertQuestion(Question question);
	
	QuestionWrapper loadQuestion(long index);
	
	List<Question> getListQuestion();
	
	QuestionWrapper updateQuestion(long id);
	
	QuestionWrapper deleteQuestion(long id);
	
	int countQuestion();
}
