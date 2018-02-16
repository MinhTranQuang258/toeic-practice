package com.tqminh.vn.toeicpractice.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.tqminh.vn.toeicpractice.datatype.JSONType;
import com.tqminh.vn.toeicpractice.model.Question;

@Entity
@TypeDef(name= "json", typeClass= JSONType.class)
public class QuestionWrapper {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Type(type= "json")
	private Question question;

	public long getId() {
		return id;
	}

	public Question getQuestion() {
		return question;
	}

	public QuestionWrapper() {
		super();
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
