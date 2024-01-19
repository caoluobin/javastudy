package org.clb.pojo;

import lombok.Data;

@Data
public class User {
    String id;
    String name;
    String bA = "asd";
    Integer age;

    public User(String id, String name, String bA, Integer age) {
        this.id = id;
        this.name = name;
        this.bA = bA;
        this.age = age;
    }

    public User() {
    }
    public static User getDefaultUser(){
        return new User("1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","张三aaaaaaaaaaaaaaaaaaaaaa","ccaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",10);
    }
}
