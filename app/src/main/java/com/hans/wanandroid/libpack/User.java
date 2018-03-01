package com.hans.wanandroid.libpack;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by hans
 * date: 2017/12/4 09:51.
 * e-mail: hxxx1992@163.com
 */
@Entity
public class User {
    @Id(autoincrement = true)
    @Index(unique = true)
    private Long id;
    private String name;
    private int age;

    private boolean sex;

    @Generated(hash = 679891439)
    public User(Long id, String name, int age, boolean sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getSex() {
        return this.sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }




}
