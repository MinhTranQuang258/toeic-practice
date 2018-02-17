package com.tqminh.vn.toeicpractice.model;

public class Account {
	
	private String name;
	
	private int age;
	
	private String userName;
	
	private String password;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Account() {
		super();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
