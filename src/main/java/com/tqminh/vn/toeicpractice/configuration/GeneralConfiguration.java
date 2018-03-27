package com.tqminh.vn.toeicpractice.configuration;

import org.springframework.beans.factory.annotation.Value;

public class GeneralConfiguration {
    
    @Value("${}")
    private String filePath;
    
    private String photoPath;
    
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
    
}
