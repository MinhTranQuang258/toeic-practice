package com.tqminh.vn.toeicpractice.services.impl;


import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqminh.vn.toeicpractice.configuration.GeneralConfiguration;
import com.tqminh.vn.toeicpractice.services.PDFService;

@Service
public class PDFServiceImpl implements PDFService{
	
	public PDFServiceImpl() throws IOException {
        super();
    }

    @Autowired
    private GeneralConfiguration configuration;

	@Override
	public void loadFile() throws InvalidPasswordException, IOException {
		File folder= new File(configuration.getPdfPatch());
        File[] files = folder.listFiles();
        
        for (File file : files) {
            PDDocument document = PDDocument.load(file);
                
        }
	}
	
	private void processDocument(PDDocument document) throws IOException {
	    
	}

	@Override
	public String readFile() {
		// TODO Auto-generated method stub
		return null;
	}
}
