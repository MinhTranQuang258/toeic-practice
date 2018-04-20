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
@TypeDef(name = "pjson", typeClass = JSONType.class, parameters = {
    @Parameter(name = JSONType.CLASS, value = Constant.JSON_PHOTO_QUESTION) })
public class PQuestionWrapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(type = "pjson")
    private PhotoQuestion photoQuestion;

    public PQuestionWrapper() {
        super();
    }

    public PQuestionWrapper(final Long id, final PhotoQuestion photoQuestion) {
        super();
        this.id = id;
        this.photoQuestion = photoQuestion;
    }

    public PQuestionWrapper(final PhotoQuestion photoQuestion) {
        super();
        this.photoQuestion = photoQuestion;
    }

    public Long getId() {
        return this.id;
    }

    public PhotoQuestion getPhotoQuestion() {
        return this.photoQuestion;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setPhotoQuestion(final PhotoQuestion photoQuestion) {
        this.photoQuestion = photoQuestion;
    }
}
