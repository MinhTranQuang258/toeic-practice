package com.tqminh.vn.toeicpractice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GeneralConfiguration {

    @Value("${app.configuration.limited.mc.question}")
    private int maxMCQuestion;

    @Value("${app.configuration.limited.p.question}")
    private int maxPQuestion;

    @Value("${app.configuration.pdf.patch}")
    private String pdfPatch;

    @Value("${app.configuration.photo.patch}")
    private String photoPath;

    public int getMaxMCQuestion() {
        return this.maxMCQuestion;
    }

    public int getMaxPQuestion() {
        return this.maxPQuestion;
    }

    public String getPdfPatch() {
        return this.pdfPatch;
    }

    public String getPhotoPath() {
        return this.photoPath;
    }

    public void setMaxMCQuestion(final int maxMCQuestion) {
        this.maxMCQuestion = maxMCQuestion;
    }

    public void setMaxPQuestion(final int maxPQuestion) {
        this.maxPQuestion = maxPQuestion;
    }

    public void setPdfPatch(final String pdfPatch) {
        this.pdfPatch = pdfPatch;
    }

    public void setPhotoPath(final String photoPath) {
        this.photoPath = photoPath;
    }
}
