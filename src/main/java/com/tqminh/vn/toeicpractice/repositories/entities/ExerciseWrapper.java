package com.tqminh.vn.toeicpractice.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.tqminh.vn.toeicpractice.datatype.JSONType;
import com.tqminh.vn.toeicpractice.model.Exercise;

@Entity
@TypeDef(name= "json", typeClass= JSONType.class)
public class ExerciseWrapper {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Type(type= "json")
	private Exercise exercise;

	public long getId() {
		return id;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public ExerciseWrapper() {
		super();
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
}
