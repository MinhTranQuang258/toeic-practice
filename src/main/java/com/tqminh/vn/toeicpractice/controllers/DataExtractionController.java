/*
 * Class: DataExtractionController
 *
 * Created on Apr 17, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package com.tqminh.vn.toeicpractice.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tqminh.vn.toeicpractice.configuration.GeneralConfiguration;
import com.tqminh.vn.toeicpractice.services.PDFService;

@RestController
public class DataExtractionController {

    @Autowired
    private GeneralConfiguration configuration;

    @Autowired
    private PDFService extractor;

    @RequestMapping(value = "/extract", method = RequestMethod.GET)
    public String extractDataFromPDF() {
        try {
            this.extractor.readFile(this.configuration.getPdfPatch());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
