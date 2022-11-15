package com.example.hw_6_hibernate.entity;


import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String cityName;
    private int age;

    public User(String firstName, String lastName, String cityName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cityName = cityName;
        this.age = age;
    }

    public User(long id, String firstName, String lastName, String cityName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cityName = cityName;
        this.age = age;
    }

    public User() {

    }
}
