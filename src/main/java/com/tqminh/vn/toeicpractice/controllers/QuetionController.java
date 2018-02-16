package com.tqminh.vn.toeicpractice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tqminh.vn.toeicpractice.services.ExerciseDAO;

@RestController
public class ExerciseController {
	
	@Autowired
	private ExerciseDAO exerciseDAO;
	
	
	@RequestMapping
	public void readExercise() {
		exerciseDAO.readExercise();
	}
	
	
}
