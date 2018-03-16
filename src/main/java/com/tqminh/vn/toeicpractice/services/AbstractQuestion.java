package com.tqminh.vn.toeicpractice.services;

import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;

public abstract class AbstractQuestion {

	protected MultipleChoiceQuestion nextQuestion() {
		
		return null;
	}
	
	protected MultipleChoiceQuestion previousQuestion() {
		
		return null;
	}
	
}
