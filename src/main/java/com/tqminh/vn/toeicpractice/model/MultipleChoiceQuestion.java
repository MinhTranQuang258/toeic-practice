package com.tqminh.vn.toeicpractice.model;

public class MultipleChoiceQuestion extends AbstractQuestion{
	
	private String detailQuestion;
	
	private String answerA;
	
	private String answerB;
	
	private String answerC;
	
	private String answerD;
	
	private String answerTrue;

	public MultipleChoiceQuestion() {
		super();
	}
	
	@Override
	public String getDetailQuestion() {
		return detailQuestion;
	}

	@Override
	public String getAnswerA() {
		return answerA;
	}

	@Override
	public String getAnswerB() {
		return answerB;
	}

	@Override
	public String getAnswerC() {
		return answerC;
	}

	@Override
	public String getAnswerD() {
		return answerD;
	}

	@Override
	public String getAnswerTrue() {
		return answerTrue;
	}

	public void setDetailQuestion(String detailQuestion) {
		this.detailQuestion = detailQuestion;
	}

	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}

	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}

	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}

	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}

	public void setAnswerTrue(String answerTrue) {
		this.answerTrue = answerTrue;
	}
	
	
}
