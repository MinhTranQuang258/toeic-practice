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
import com.tqminh.vn.toeicpractice.model.Account;

@Entity
@TypeDef(name = "json", typeClass = JSONType.class, parameters = {
    @Parameter(name = JSONType.CLASS, value = Constant.JSON_ACCOUNT) })
public class AccountWrapper {

    @Type(type = "json")
    private Account account;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public AccountWrapper() {
        super();
    }

    public AccountWrapper(final Account account) {
        super();
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }

    public long getId() {
        return this.id;
    }

    public void setAccount(final Account account) {
        this.account = account;
    }

    public void setId(final long id) {
        this.id = id;
    }
}
