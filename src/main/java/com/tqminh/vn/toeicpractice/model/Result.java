package com.tqminh.vn.toeicpractice.model;


public class Result {
	
	private String name;
	
	private double score;
	
	private String date;
	
	private boolean multipleChoice;
	
	private boolean sentence;
	
	private boolean photo;
	
	private int lastSentence;

	public String getName() {
		return name;
	}

	public double getScore() {
		return score;
	}

	public String getDate() {
		return date;
	}

	public boolean isMultipleChoice() {
		return multipleChoice;
	}

	public boolean isSentence() {
		return sentence;
	}

	public boolean isPhoto() {
		return photo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setMultipleChoice(boolean multipleChoice) {
		this.multipleChoice = multipleChoice;
	}

	public void setSentence(boolean sentence) {
		this.sentence = sentence;
	}

	public void setPhoto(boolean photo) {
		this.photo = photo;
	}

	public Result() {
		super();
	}

	public int getLastSentence() {
		return lastSentence;
	}

	public void setLastSentence(int lastSentence) {
		this.lastSentence = lastSentence;
	}
}
