package com.tqminh.vn.toeicpractice.model;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private String date;

    private List<Double> multipleChoices;

    private List<Double> photos;

    private List<Double> sentences;

    private String timestamp;

    private String username;

    public Result() {
        super();
        this.multipleChoices = new ArrayList<>();
        this.sentences = new ArrayList<>();
        this.photos = new ArrayList<>();
    }

    public Result(final String username, final String date,
            final String timestamp) {
        super();
        this.username = username;
        this.date = date;
        this.timestamp = timestamp;
        this.multipleChoices = new ArrayList<>();
        this.sentences = new ArrayList<>();
        this.photos = new ArrayList<>();
    }

    public Result(final String username, final String date,
            final String timestamp, final List<Double> multipleChoices,
            final List<Double> sentences, final List<Double> photos) {
        super();
        this.username = username;
        this.date = date;
        this.timestamp = timestamp;
        this.multipleChoices = multipleChoices;
        this.sentences = sentences;
        this.photos = photos;
    }

    public String getDate() {
        return this.date;
    }

    public List<Double> getMultipleChoices() {
        return this.multipleChoices;
    }

    public List<Double> getPhotos() {
        return this.photos;
    }

    public List<Double> getSentences() {
        return this.sentences;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getUsername() {
        return this.username;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public void setMultipleChoices(final List<Double> multipleChoices) {
        this.multipleChoices = multipleChoices;
    }

    public void setPhotos(final List<Double> photos) {
        this.photos = photos;
    }

    public void setSentences(final List<Double> sentences) {
        this.sentences = sentences;
    }

    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }

    public void setUsername(final String username) {
        this.username = username;
    }
}
