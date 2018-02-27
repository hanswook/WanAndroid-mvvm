package com.hans.wanandroid.model.mock;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.hans.wanandroid.BR;

/**
 * Created by hans
 * date: 2018/2/27 18:04.
 * e-mail: hxxx1992@163.com
 */

public class MockUser extends BaseObservable {
    private String name;
    private int age;
    private boolean sex;

    public MockUser(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public MockUser() {
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);

    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
