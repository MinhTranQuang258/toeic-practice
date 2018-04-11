package com.tqminh.vn.toeicpractice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GeneralConfiguration {
    
    @Value("${app.configuration.photo.patch}")
    private String photoPath;
    
    @Value("${app.configuration.limited.mc.question}")
    private int maxMCQuestion;
    
    @Value("${app.configuration.limited.p.question}")
    private int minPQuestion;

//    @Value("${app.configuration.pdf.patch}")
    private String pdfPatch;

    public String getPdfPatch() {
        return pdfPatch;
    }

    public void setPdfPatch(String pdfPatch) {
        this.pdfPatch = pdfPatch;
    }

    public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public int getMaxMCQuestion() {
		return maxMCQuestion;
	}

	public void setMaxMCQuestion(int maxMCQuestion) {
		this.maxMCQuestion = maxMCQuestion;
	}

	public int getMinPQuestion() {
		return minPQuestion;
	}

	public void setMinPQuestion(int minPQuestion) {
		this.minPQuestion = minPQuestion;
	}
}
