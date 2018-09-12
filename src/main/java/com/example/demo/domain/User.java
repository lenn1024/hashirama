package com.example.demo.domain;

public class User {
    private String name;

    private int age;

    private boolean famale;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFamale() {
        return famale;
    }

    public void setFamale(boolean famale) {
        this.famale = famale;
    }
}
