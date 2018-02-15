package com.tqminh.vn.toeicpractice.model;

public class User {
	
	private String name;
	
	private int age;
	
	private String user;
	
	private String password;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public User() {
		super();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
