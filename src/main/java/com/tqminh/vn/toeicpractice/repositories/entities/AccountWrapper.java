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
@TypeDef(name= "json", typeClass= JSONType.class, parameters= {
		@Parameter(name= JSONType.CLASS, value= Constant.JSON_ACCOUNT)})
public class AccountWrapper {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Type(type= "json")
	private Account account;

	public AccountWrapper() {
		super();
	}
	
	public AccountWrapper(Account account) {
		super();
		this.account = account;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Account getUser() {
		return account;
	}

	public void setUser(Account account) {
		this.account = account;
	}
}
