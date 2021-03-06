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
@TypeDef(name = "mcjson", typeClass = JSONType.class, parameters = {
    @Parameter(name = JSONType.CLASS, value = Constant.JSON_MULTIPLE_CHOICE_QUESTION) })
public class MCQuestionWrapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Type(type = "mcjson")
    private MultipleChoiceQuestion multipleChoiceQuestion;

    public MCQuestionWrapper() {
        super();
    }

    public MCQuestionWrapper(final long id,
            final MultipleChoiceQuestion multipleChoiceQuestion) {
        super();
        this.id = id;
        this.multipleChoiceQuestion = multipleChoiceQuestion;
    }

    public MCQuestionWrapper(
            final MultipleChoiceQuestion multipleChoiceQuestion) {
        super();
        this.multipleChoiceQuestion = multipleChoiceQuestion;
    }

    public long getId() {
        return this.id;
    }

    public MultipleChoiceQuestion getMultipleChoiceQuestion() {
        return this.multipleChoiceQuestion;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setMultipleChoiceQuestion(
        final MultipleChoiceQuestion multipleChoiceQuestion) {
        this.multipleChoiceQuestion = multipleChoiceQuestion;
    }
}
