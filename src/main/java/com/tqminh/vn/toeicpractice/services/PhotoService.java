package com.tqminh.vn.toeicpractice.services;

import java.io.IOException;
import java.util.Queue;

public interface PhotoService {
 
	String loadFilePatch() throws IOException;
	
	void setPatch(String patch);
	
	Queue<String> readFile() throws IOException;
	
	int countPhoto() throws IOException;
	
}
