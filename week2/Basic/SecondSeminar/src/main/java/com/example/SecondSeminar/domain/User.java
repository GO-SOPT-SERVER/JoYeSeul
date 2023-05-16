package com.example.SecondSeminar.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter //사실 Setter 열어놓는 것은 좋지 않음
public class User {
    private Long id;
    private String gender;
    private String name;
    private int age;
    private String contact;

    public User(String gender, String name, String contact, int age) {
        this.gender = gender;
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    public String toString() {
        return "id: " + this.id + "\n" +
                "gender: " + this.gender + "\n" +
                "name: " + this.name + "\n" +
                "contact: " + this.contact + "\n" +
                "age: " + this.age;
    }

}