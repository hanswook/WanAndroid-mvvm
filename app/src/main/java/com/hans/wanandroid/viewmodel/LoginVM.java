package com.hans.wanandroid.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by hans
 * date: 2018/2/28 18:52.
 * e-mail: hxxx1992@163.com
 */

public class LoginVM extends BaseObservable {
    private String account;
    private String password;


    @Bindable
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
