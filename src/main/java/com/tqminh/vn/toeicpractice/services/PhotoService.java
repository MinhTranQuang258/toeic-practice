package com.tqminh.vn.toeicpractice.services;

import java.io.IOException;
import java.util.List;

public interface PhotoService {
 
	void loadFile();
	
	void setPatch(String patch);
	
	List<String> readFile() throws IOException;
	
	int countPhoto() throws IOException;
	
}
