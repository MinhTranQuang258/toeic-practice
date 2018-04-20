package com.tqminh.vn.toeicpractice.model.mapping;

public class Register {

    private int age;

    private String name;

    private String password;

    private String repassword;

    private String username;

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRepassword() {
        return this.repassword;
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

    public void setRepassword(final String repassword) {
        this.repassword = repassword;
    }

    public void setUsername(final String username) {
        this.username = username;
    }
}
