/*
 * Class: DataExtractor
 *
 * Created on Apr 16, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package com.tqminh.vn.toeicpractice.services.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
import org.springframework.stereotype.Component;

import com.tqminh.vn.toeicpractice.services.PDFService;

@Component
public class DataExtractor extends PDFTextStripper implements PDFService{
    
    private Writer writer;
    
    private String patch;

    public DataExtractor() throws IOException {
        super();
        writer= new OutputStreamWriter(new ByteArrayOutputStream());
    }
    

    @Override
    protected void writeString(String text, List<TextPosition> textPositions)
            throws IOException {
        
    }
    
    @Override
    public void setSortByPosition(boolean newSortByPosition) {
        super.setSortByPosition(newSortByPosition);
    }
    
    @Override
    public void setStartPage(int startPageValue) {
        super.setStartPage(startPageValue);
    }
    
    @Override
    public void setEndPage(int endPageValue) {
        super.setEndPage(endPageValue);
    }

    private File loadFile() throws InvalidPasswordException, IOException {
        File file= new File(patch);
        return file;
    }
    
    private void processDocument() throws InvalidPasswordException, IOException {
        PDDocument document = PDDocument.load(loadFile());
        super.writeText(document, writer);
    }

    @Override
    public void readFile(String patch) throws InvalidPasswordException, IOException {
        this.patch= patch; 
        processDocument();
    }    
}
