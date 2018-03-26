package com.tqminh.vn.toeicpractice.model;

import java.util.ArrayList;
import java.util.List;

public class Result {
	
	private String name;
	
	private String date;
	
	private List<Double> multipleChoices;
	
	private List<Double> sentences;
	
	private List<Double> photos;
	
	public Result() {
		super();
		multipleChoices= new ArrayList<>();
		sentences= new ArrayList<>();
		photos= new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public List<Double> getMultipleChoices() {
		return multipleChoices;
	}


	public void setMultipleChoices(List<Double> multipleChoices) {
		this.multipleChoices = multipleChoices;
	}


	public List<Double> getSentences() {
		return sentences;
	}


	public void setSentences(List<Double> sentences) {
		this.sentences = sentences;
	}


	public List<Double> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Double> photos) {
		this.photos = photos;
	}
}
