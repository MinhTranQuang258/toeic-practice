package com.tqminh.vn.toeicpractice.services;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

public interface PDFService {
	
	void readFile(String patch) throws InvalidPasswordException, IOException;
	
	void setSortByPosition(boolean newSortByPosition);
	
	void setStartPage(int startPageValue);
	
	void setEndPage(int endPageValue);
	
}
