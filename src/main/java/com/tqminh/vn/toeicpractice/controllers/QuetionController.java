package com.tqminh.vn.toeicpractice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tqminh.vn.toeicpractice.services.QuestionDAO;

@RestController
public class QuetionController {
	
	@Autowired
	private QuestionDAO exerciseDAO;
	
	
	@RequestMapping(value= "readQuestion", method= RequestMethod.GET)
	public void readQuestion() {
		exerciseDAO.readQuestion();
	}
}
