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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqminh.vn.toeicpractice.configuration.GeneralConfiguration;
import com.tqminh.vn.toeicpractice.services.PDFService;

@Service
public class PDFServiceImpl extends PDFTextStripper implements PDFService{
	
	public PDFServiceImpl() throws IOException {
        super();
    }

    @Autowired
    private GeneralConfiguration configuration;

	@Override
	public void loadFile() throws InvalidPasswordException, IOException {
		File folder= new File(configuration.getPdfPatch());
        File[] files = folder.listFiles();
        
        for (File file : files) {
            PDDocument document = PDDocument.load(file);
                
        }
	}
	
	private void processDocument(PDDocument document) throws IOException {
	    setSortByPosition(true);
	    setStartPage(0);
	    setEndPage(document.getNumberOfPages());
	    
	    Writer writer= new OutputStreamWriter(new ByteArrayOutputStream());
	    writeText(document, writer);
	    
	}

	@Override
	public String readFile() {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    protected void writeString(String text, List<TextPosition> textPositions)
            throws IOException {
        
    } 
}
