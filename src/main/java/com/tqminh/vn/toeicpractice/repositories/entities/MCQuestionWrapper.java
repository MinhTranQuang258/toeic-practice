package com.tqminh.vn.toeicpractice.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.jsontype.JSONType;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;

@Entity
@TypeDef(name= "json", typeClass= JSONType.class, parameters= {
		@Parameter(name= JSONType.CLASS, value= Constant.JSON_MULTIPLE_CHOICE_QUESTION)})
public class MCQuestionWrapper {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Type(type= "json")
	private MultipleChoiceQuestion question;

	public long getId() {
		return id;
	}

	public MultipleChoiceQuestion getQuestion() {
		return question;
	}

	public MCQuestionWrapper() {
		super();
	}

	public MCQuestionWrapper(MultipleChoiceQuestion question) {
		super();
		this.question = question;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setQuestion(MultipleChoiceQuestion question) {
		this.question = question;
	}
}
