package com.tqminh.vn.toeicpractice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QuetionController {
	
//	@Autowired
//	private QuestionDAO questionDAO;
	
	
	@RequestMapping(value= "/readQuestion", method= RequestMethod.GET)
	public void readQuestion() {
	}
	
	@RequestMapping(value="creatQuestion", method= RequestMethod.POST)
	public void createQuestion() {
	}	
}
