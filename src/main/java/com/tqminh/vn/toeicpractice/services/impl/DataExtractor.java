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

import com.tqminh.vn.toeicpractice.model.AbstractQuestion;
import com.tqminh.vn.toeicpractice.services.PDFService;

@Component
public class DataExtractor extends PDFTextStripper implements PDFService {

    private String patch;

    private final Writer writer;

    public DataExtractor() throws IOException {
        super();
        this.writer = new OutputStreamWriter(new ByteArrayOutputStream());
    }

    private File loadFile() throws InvalidPasswordException, IOException {
        File file = new File(this.patch);
        return file;
    }

    private void processDocument()
            throws InvalidPasswordException, IOException {
        PDDocument document = PDDocument.load(this.loadFile());
        super.writeText(document, this.writer);
    }

    @Override
    public void readFile(final String patch)
            throws InvalidPasswordException, IOException {
        this.patch = patch;
        this.processDocument();
    }

    @Override
    public void setEndPage(final int endPageValue) {
        super.setEndPage(endPageValue);
    }

    @Override
    public void setSortByPosition(final boolean newSortByPosition) {
        super.setSortByPosition(newSortByPosition);
    }

    @Override
    public void setStartPage(final int startPageValue) {
        super.setStartPage(startPageValue);
    }

    @Override
    public AbstractQuestion viewQuestion(final String s) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void writeString(
        final String text,
        final List<TextPosition> textPositions) throws IOException {
        System.out.println(text);
    }
}
