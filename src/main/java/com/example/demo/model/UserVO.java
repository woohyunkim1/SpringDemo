package com.example.demo.model;

import lombok.Data;


@Data
public class UserVO {

    private String username;
    private int age;

    public UserVO(String username, int age) {
        this.username = username;
        this.age = age;
    }

}
