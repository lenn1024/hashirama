package com.example.demo.domain;

public class User {
    private String name;

    private int age;

    private boolean famale;

    public User() {
    }

    public User(String name, int age, boolean famale) {
        this.name = name;
        this.age = age;
        this.famale = famale;
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
