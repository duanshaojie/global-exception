package com.exception.globalexception.model;

/**
 * <p><b>@name:</b> User.java</p>
 * <p><b>@title:</b> 用户</p>
 * <p>@description: </p>
 * <p>@author: <font color='blue'>Edison</font></p>
 * <p>@time: 2019年12月05日 20点23分</p>
 * <p>
 * 桃之夭夭,灼灼其华
 */
public class User {

    private long id;

    private String name;

    private Integer age;

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }
}
