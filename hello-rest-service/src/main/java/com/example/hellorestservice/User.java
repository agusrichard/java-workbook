package com.example.hellorestservice;

public class User {
    private final long id;
    private final String name;
    private final int age;

    public User(String name, int age) {
        this.id = 0;
        this.name = name;
        this.age = age;
    }

    public User(long id, String name, int age) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
