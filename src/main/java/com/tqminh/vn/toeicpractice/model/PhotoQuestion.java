package com.tqminh.vn.toeicpractice.model;

public class PhotoQuestion extends AbstractQuestion {

    private String answerA;

    private String answerB;

    private String answerC;

    private String answerD;

    private String answerTrue;

    private String folderName;

    private String photo;

    private String sound;

    public PhotoQuestion() {
        super();
    }

    public PhotoQuestion(final String photo, final String answerA,
            final String answerB, final String answerC, final String answerD,
            final String answerTrue) {
        super();
        this.photo = photo;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.answerTrue = answerTrue;
    }

    public PhotoQuestion(final String answerA, final String answerB,
            final String answerC, final String answerD, final String answerTrue,
            final String folderName, final String photo, final String sound) {
        super();
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.answerTrue = answerTrue;
        this.folderName = folderName;
        this.photo = photo;
        this.sound = sound;
    }

    @Override
    public String getAnswerA() {
        return this.answerA;
    }

    @Override
    public String getAnswerB() {
        return this.answerB;
    }

    @Override
    public String getAnswerC() {
        return this.answerC;
    }

    @Override
    public String getAnswerD() {
        return this.answerD;
    }

    @Override
    public String getAnswerTrue() {
        return this.answerTrue;
    }

    @Override
    public String getDetailQuestion() {
        return this.getPhoto();
    }

    public String getFolderName() {
        return this.folderName;
    }

    private String getPhoto() {
        return this.photo;
    }

    public String getSound() {
        return this.sound;
    }

    public void setAnswerA(final String answerA) {
        this.answerA = answerA;
    }

    public void setAnswerB(final String answerB) {
        this.answerB = answerB;
    }

    public void setAnswerC(final String answerC) {
        this.answerC = answerC;
    }

    public void setAnswerD(final String answerD) {
        this.answerD = answerD;
    }

    public void setAnswerTrue(final String answerTrue) {
        this.answerTrue = answerTrue;
    }

    public void setFolderName(final String folderName) {
        this.folderName = folderName;
    }

    public void setPhoto(final String photo) {
        this.photo = photo;
    }

    public void setSound(final String sound) {
        this.sound = sound;
    }
}
