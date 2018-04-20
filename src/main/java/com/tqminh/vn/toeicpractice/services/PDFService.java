package com.tqminh.vn.toeicpractice.services;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

import com.tqminh.vn.toeicpractice.model.AbstractQuestion;

public interface PDFService {

    void readFile(String patch) throws InvalidPasswordException, IOException;

    void setEndPage(int endPageValue);

    void setSortByPosition(boolean newSortByPosition);

    void setStartPage(int startPageValue);

    AbstractQuestion viewQuestion(String s);
}
