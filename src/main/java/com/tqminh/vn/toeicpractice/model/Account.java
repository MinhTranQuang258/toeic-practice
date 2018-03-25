package com.tqminh.vn.toeicpractice.model;

public class Account {
	
	private String name;
	
	private int age;
	
	private String username;
	
	private String password;
	
	public Account() {
		super();
	}

	public Account(String name, int age, String username) {
		super();
		this.name = name;
		this.age = age;
		this.username = username;
	}

	public Account(String name, int age, String username, String password) {
		super();
		this.name = name;
		this.age = age;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
