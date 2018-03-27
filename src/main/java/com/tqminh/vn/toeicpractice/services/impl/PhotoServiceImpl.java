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

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Autowired;

import com.tqminh.vn.toeicpractice.configuration.GeneralConfiguration;
import com.tqminh.vn.toeicpractice.services.PhotoService;

public class PhotoServiceImpl implements PhotoService{
    
    @Autowired
    private GeneralConfiguration configuration;

    @Override
    public void loadFile() throws InvalidPasswordException, IOException {
        File folder= new File(configuration.getFilePatch());
        File[] files = folder.listFiles();
        
//        Splitters splitters= new Splitters();
        
        for (File file : files) {
            PDDocument document = PDDocument.load(file);
//            splitters.splitDocument(document);
        }
    }

    @Override
    public String readFile() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
