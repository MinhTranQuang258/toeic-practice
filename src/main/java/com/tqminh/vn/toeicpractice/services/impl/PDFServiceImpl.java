package com.tqminh.vn.toeicpractice.services.impl;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Autowired;

import com.tqminh.vn.toeicpractice.configuration.GeneralConfiguration;
import com.tqminh.vn.toeicpractice.services.PDFService;

public class PDFServiceImpl implements PDFService{
	
	@Autowired
    private GeneralConfiguration configuration;

	@Override
	public void loadFile() throws InvalidPasswordException, IOException {
		File folder= new File(configuration.getPdfPatch());
        File[] files = folder.listFiles();
        
        
        for (File file : files) {
            PDDocument document = PDDocument.load(file);
//            splitters.splitDocument(document);
        }
	}

	@Override
	public String readFile() {
		// TODO Auto-generated method stub
		return null;
	} 
	
}
