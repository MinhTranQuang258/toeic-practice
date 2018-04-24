/*
 * Class: PDFService
 *
 * Created on Apr 24, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package com.tqminh.vn.toeicpractice.services;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

import com.tqminh.vn.toeicpractice.model.AbstractQuestion;

/**
 * The Interface PDFService.
 */
public interface PDFService {

    /**
     * Read file.
     *
     * @param patch the patch
     * @throws InvalidPasswordException the invalid password exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    void readFile(String patch) throws InvalidPasswordException, IOException;

    /**
     * Sets the end page of PDF file.
     *
     * @param endPageValue the new end page
     */
    void setEndPage(int endPageValue);

    /**
     * Sets the sort by position.
     *
     * @param newSortByPosition the new sort by position
     */
    void setSortByPosition(boolean newSortByPosition);

    /**
     * Sets the start page.
     *
     * @param startPageValue the new start page
     */
    void setStartPage(int startPageValue);

    /**
     * View question.
     *
     * @param s the s
     * @return the abstract question
     */
    AbstractQuestion viewQuestion(String s);
}
