package com.tqminh.vn.toeicpractice.controllers;



import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.services.QuestionService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	@Qualifier("MCQuestionService")
	private QuestionService<MultipleChoiceQuestion> mcQuestionService;
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public void save() {
	    for(int i= 0; i < 11; i++) {
	        MultipleChoiceQuestion multipleChoiceQuestion= new MultipleChoiceQuestion("Câu " + 1, "1", "2", "3", "4", "1");
	        try {
                mcQuestionService.insertQuestion(multipleChoiceQuestion);
            }
            catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }
	    }
	}
}
