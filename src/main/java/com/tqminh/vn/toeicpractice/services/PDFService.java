package com.tqminh.vn.toeicpractice.services;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

public interface PDFService {
	
	void loadFile() throws InvalidPasswordException, IOException;
	
	String readFile();
	
	
	
}
