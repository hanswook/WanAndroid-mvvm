package com.hans.wanandroid.model.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.hans.wanandroid.BR;

/**
 * Created by hans
 * date: 2018/3/6 16:21.
 * e-mail: hxxx1992@163.com
 */

public class LoginStatusBean extends BaseObservable {
    private boolean loginStatus;

    @Bindable
    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
        notifyPropertyChanged(BR.loginStatus);
    }

    public LoginStatusBean(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public LoginStatusBean() {
    }
}
