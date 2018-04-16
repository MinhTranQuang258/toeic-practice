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
package com.tqminh.vn.toeicpractice.common.tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
import org.springframework.stereotype.Component;

@Component
public class DataExtractor extends PDFTextStripper{
    
    private Writer writer;
    
    @Override
    public void setStartPage(int startPageValue) {
        super.setStartPage(startPageValue);
    }

    public DataExtractor() throws IOException {
        super();
        writer= new OutputStreamWriter(new ByteArrayOutputStream());
    }
    
    public void processDocument(PDDocument document) {
        
    }

    @Override
    protected void writeString(String text, List<TextPosition> textPositions)
            throws IOException {
        // TODO Auto-generated method stub
        super.writeString(text, textPositions);
    }
    
}
