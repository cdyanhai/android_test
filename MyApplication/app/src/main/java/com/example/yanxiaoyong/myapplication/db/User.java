package com.example.yanxiaoyong.myapplication.db;

import io.realm.RealmObject;

/**
 * Created by yanxiaoyong on 2016/7/27.
 */
public class User extends RealmObject {
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

    private  String name;
    private int age;



}
