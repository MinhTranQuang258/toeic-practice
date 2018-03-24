package com.tqminh.vn.toeicpractice.model.list;

import java.util.List;

import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;

public class MCQuestionList {
	
	private List<MultipleChoiceQuestion> questions;

	public MCQuestionList() {
		super();
	}
	
	public MCQuestionList(List<MultipleChoiceQuestion> questions) {
		super();
		this.questions = questions;
	}

	public List<MultipleChoiceQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<MultipleChoiceQuestion> questions) {
		this.questions = questions;
	}
}
