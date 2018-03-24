package com.tqminh.vn.toeicpractice.model.list;

import java.util.List;

import com.tqminh.vn.toeicpractice.model.PhotoQuestion;


public class PQuestionList {
	private List<PhotoQuestion> questions;

	public PQuestionList() {
		super();
	}
	
	public PQuestionList(List<PhotoQuestion> questions) {
		super();
		this.questions = questions;
	}

	public List<PhotoQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<PhotoQuestion> questions) {
		this.questions = questions;
	}
}
