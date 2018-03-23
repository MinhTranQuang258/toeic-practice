package com.tqminh.vn.toeicpractice.model;

import java.util.List;

public class QuestionList {
	
	private List<AbstractQuestion> questions;

	public QuestionList() {
		super();
	}
	
	public QuestionList(List<AbstractQuestion> questions) {
		super();
		this.questions = questions;
	}

	public List<AbstractQuestion> getQuestions() {
		return questions;
	}
}
