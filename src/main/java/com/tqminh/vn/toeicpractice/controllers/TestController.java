package com.tqminh.vn.toeicpractice.controllers;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tqminh.vn.toeicpractice.configuration.GeneralConfiguration;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.services.PDFService;
import com.tqminh.vn.toeicpractice.services.QuestionService;

@RestController
public class TestController {

    @Autowired
    @Qualifier("MCQuestionService")
    private QuestionService<MultipleChoiceQuestion> mcQuestionService;
    
    @Autowired
    private GeneralConfiguration configuration;

    @Autowired
    private PDFService extractor;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save() {
        for (int i = 0; i < 11; i++) {
            MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion(
                "Câu " + i, "1", "2", "3", "4", "1");
            try {
                this.mcQuestionService.insertQuestion(multipleChoiceQuestion);
            }
            catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

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
