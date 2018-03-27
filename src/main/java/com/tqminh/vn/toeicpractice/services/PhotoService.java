package com.tqminh.vn.toeicpractice.services;

import java.io.IOException;
import java.util.List;

public interface PhotoService {
 
	void loadFile();
	
	List<String> readFile() throws IOException;
	
}
