package com.tqminh.vn.toeicpractice.services;


import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;

public interface QuestionService {
	
	String insertQuestion(MultipleChoiceQuestion question);
	
	MultipleChoiceQuestion loadQuestion(long index);
	
	MultipleChoiceQuestion updateQuestion(long id);
	
	MultipleChoiceQuestion deleteQuestion(long id);
	
	int countQuestion();
	
	MultipleChoiceQuestion nextQuestion();
	
	MultipleChoiceQuestion previousQuestion();
}
