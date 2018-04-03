package com.tqminh.vn.toeicpractice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GeneralConfiguration {
    
    private String filePath;
    
    @Value("${app.configuration.photo.patch}")
    private String photoPath;
    
    @Value("${app.configuration.limited.mc.question}")
    private int maxMCQuestion;
    
    @Value("${app.configuration.limited.p.question}")
    private int minPQuestion;
    
    public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
