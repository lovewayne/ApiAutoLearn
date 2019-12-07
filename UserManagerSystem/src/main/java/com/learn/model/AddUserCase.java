package com.learn.model;

import lombok.Data;

@Data
public class AddUser {
    private String userName;
    private String passwd;
    private int age;
    private int sex;
    private int permission;
    private int delFlag;
    private String expected;
}
