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
import com.tqminh.vn.toeicpractice.model.Result;

@Entity
@TypeDef(name = "rsjson", typeClass = JSONType.class, parameters = {
    @Parameter(name = JSONType.CLASS, value = Constant.JSON_RESULT) })
public class ResultWrapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Type(type = "rsjson")
    private Result result;

    public ResultWrapper() {
        super();
    }

    public ResultWrapper(final long id, final Result result) {
        super();
        this.id = id;
        this.result = result;
    }

    public ResultWrapper(final Result result) {
        super();
        this.result = result;
    }

    public long getId() {
        return this.id;
    }

    public Result getResult() {
        return this.result;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setResult(final Result result) {
        this.result = result;
    }
}
