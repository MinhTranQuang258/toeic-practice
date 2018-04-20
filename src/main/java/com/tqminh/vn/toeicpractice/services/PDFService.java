package com.tqminh.vn.toeicpractice.services;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

import com.tqminh.vn.toeicpractice.model.AbstractQuestion;

public interface PDFService {
	
	void readFile(String patch) throws InvalidPasswordException, IOException;
	
	void setSortByPosition(boolean newSortByPosition);
	
	void setStartPage(int startPageValue);
	
	void setEndPage(int endPageValue);
	
	AbstractQuestion viewQuestion(String s);
}
