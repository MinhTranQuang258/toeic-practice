package com.tqminh.vn.toeicpractice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tqminh.vn.toeicpractice.services.QuestionService;


@Controller
@RequestMapping(value= "/question")
public class QuetionController {
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(method= RequestMethod.GET, produces= "application/json")
	public void readQuestion() {
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public void createQuestion() {
	}	
}
