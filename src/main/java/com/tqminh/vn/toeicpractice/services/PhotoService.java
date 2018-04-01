package com.tqminh.vn.toeicpractice.services;

import java.io.IOException;

public interface PhotoService {
 
	String loadFilePatch() throws IOException;
	
	int countPhoto() throws IOException;	
}
