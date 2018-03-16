package com.tqminh.vn.toeicpractice.services;

import com.tqminh.vn.toeicpractice.model.Question;

public abstract class AbstractQuestion {

	protected Question nextQuestion() {
		
		return null;
	}
	
	protected Question previousQuestion() {
		
		return null;
	}
	
}
