package com.tqminh.vn.toeicpractice.services;

import com.tqminh.vn.toeicpractice.model.Exercise;
import com.tqminh.vn.toeicpractice.repositories.entities.ExerciseWrapper;

public interface ExerciseDAO {
	
	void createExercise(Exercise exercise);
	
	ExerciseWrapper readExercise();
}
