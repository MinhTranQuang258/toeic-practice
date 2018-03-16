package com.tqminh.vn.toeicpractice.services;

import com.tqminh.vn.toeicpractice.repositories.entities.QuestionWrapper;

public abstract class AbstractQuestion {

	protected QuestionWrapper nextQuestion() {
		
		return null;
	}
	
	protected QuestionWrapper previousQuestion() {
		
		return null;
	}
	
}
