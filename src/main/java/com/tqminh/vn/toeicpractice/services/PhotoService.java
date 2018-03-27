package com.tqminh.vn.toeicpractice.services;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

public interface PhotoService {
 
	void loadFile() throws InvalidPasswordException, IOException;
	
	String readFile();
	
}
