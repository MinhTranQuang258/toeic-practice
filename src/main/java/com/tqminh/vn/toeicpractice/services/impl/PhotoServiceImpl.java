/*
 * Class: PhotoServiceImpl
 *
 * Created on Mar 27, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package com.tqminh.vn.toeicpractice.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.beans.factory.annotation.Autowired;

import com.tqminh.vn.toeicpractice.configuration.GeneralConfiguration;
import com.tqminh.vn.toeicpractice.services.PhotoService;

public class PhotoServiceImpl implements PhotoService{
    
    @Autowired
    private GeneralConfiguration configuration;

    @Override
    public String loadFilePatch() throws IOException {
        return readFile().poll();
    }

    @Override
    public Queue<String> readFile() throws IOException{
    	Queue<String> queue= new ConcurrentLinkedQueue<String>();
        File[] files= new File(configuration.getPhotoPath()).listFiles();
        for(File file : files){
        	if(file.isFile()){
        		queue.add(file.getAbsolutePath());
        	}
        }
        return queue;
    }

	@Override
	public void setPatch(String patch) {
		configuration.setPhotoPath(patch);
	}

	@Override
	public int countPhoto() throws IOException {
		return readFile().size();
	}
    
}
