package com.tqminh.vn.toeicpractice.configuration;

import org.springframework.beans.factory.annotation.Value;

public class GeneralConfiguration {
    
    @Value("${}")
    private String filePatch;
    
    public String getFilePatch() {
        return filePatch;
    }

    public void setFilePatch(String filePatch) {
        this.filePatch = filePatch;
    }
    
}
