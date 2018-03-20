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
import com.tqminh.vn.toeicpractice.model.PhotoQuestion;

@Entity
@TypeDef(name= "json", typeClass= JSONType.class, parameters= {
		@Parameter(name= JSONType.CLASS, value= Constant.JSON_PHOTO_QUESTION)})
public class PQuestionWrapper {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Type(type= "json")
	private PhotoQuestion photoQuestion;

	public PQuestionWrapper(PhotoQuestion photoQuestion) {
		super();
		this.photoQuestion = photoQuestion;
	}

	public PQuestionWrapper() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PhotoQuestion getPhotoQuestion() {
		return photoQuestion;
	}

	public void setPhotoQuestion(PhotoQuestion photoQuestion) {
		this.photoQuestion = photoQuestion;
	}
}
