package com.tqminh.vn.toeicpractice.services;

import com.tqminh.vn.toeicpractice.model.Question;
import com.tqminh.vn.toeicpractice.repositories.entities.QuestionWrapper;

public interface QuestionDAO {
	
	void createQuestion(Question question);
	
	QuestionWrapper readQuestion();
}
