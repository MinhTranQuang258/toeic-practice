package com.tqminh.vn.toeicpractice.model;

public class Account {

    private int age;

    private String name;

    private String password;

    private String username;

    public Account() {
        super();
    }

    public Account(final String name, final int age, final String username) {
        super();
        this.name = name;
        this.age = age;
        this.username = username;
    }

    public Account(final String name, final int age, final String username,
            final String password) {
        super();
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public Account(final String username, final String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setUsername(final String username) {
        this.username = username;
    }
}
