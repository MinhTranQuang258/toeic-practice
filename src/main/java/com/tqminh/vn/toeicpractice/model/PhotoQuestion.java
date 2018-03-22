package com.tqminh.vn.toeicpractice.model;

public class PhotoQuestion extends AbstractQuestion {
	
	private String photo;
	
	private String answerA;
	
	private String answerB;
	
	private String answerC;
	
	private String answerD;
	
	private String answerTrue;

	public PhotoQuestion(String photo, String answerA, String answerB, String answerC, String answerD,
			String answerTrue) {
		super();
		this.photo = photo;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.answerTrue = answerTrue;
	}
	
	public PhotoQuestion() {
		super();
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAnswerA() {
		return answerA;
	}

	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}

	public String getAnswerB() {
		return answerB;
	}

	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}

	public String getAnswerC() {
		return answerC;
	}

	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}

	public String getAnswerD() {
		return answerD;
	}

	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}

	public String getAnswerTrue() {
		return answerTrue;
	}

	public void setAnswerTrue(String answerTrue) {
		this.answerTrue = answerTrue;
	}
}
