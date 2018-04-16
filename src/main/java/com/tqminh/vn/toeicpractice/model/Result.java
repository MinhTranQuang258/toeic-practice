package com.tqminh.vn.toeicpractice.model;

import java.util.ArrayList;
import java.util.List;

public class Result {
	
	private String username;
	
	private String date;
	
	private String timestamp;
	
	private List<Double> multipleChoices;
	
	private List<Double> sentences;
	
	private List<Double> photos;
	
	public Result() {
		super();
		multipleChoices= new ArrayList<>();
		sentences= new ArrayList<>();
		photos= new ArrayList<>();
	}

	public Result(String username, String date, String timestamp) {
        super();
        this.username = username;
        this.date = date;
        multipleChoices= new ArrayList<>();
        sentences= new ArrayList<>();
        photos= new ArrayList<>();
    }

    public String getUsername() {
		return username;
	}

	public String getDate() {
		return date;
	}

	public void setUsername(String username) {
		this.username = username;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
