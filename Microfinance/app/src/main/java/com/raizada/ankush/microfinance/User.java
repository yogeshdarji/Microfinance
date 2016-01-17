package com.raizada.ankush.microfinance;

/**
 * Created by yogeshdarji on 1/16/16.
 */
public class User {

    String name,ssn,email, username, password;
    int age;

    public User(String name, int age, String ssn, String email, String username, String password) {
        this.name = name;
        this.age = age;
        this.ssn = ssn;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this("", -1,"","", username, password);
    }
}
