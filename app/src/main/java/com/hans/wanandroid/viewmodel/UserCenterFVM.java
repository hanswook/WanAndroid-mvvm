package com.hans.wanandroid.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.hans.wanandroid.databinding.FragmentUserCenterBinding;
import com.hans.wanandroid.libpack.BaseVM;
import com.hans.wanandroid.utils.Constant;
import com.hans.wanandroid.view.activity.ColloectionActivity;
import com.hans.wanandroid.view.activity.LoginActivity;
import com.njqg.orchard.library_core.utils.LogUtils;
import com.njqg.orchard.library_core.utils.SPUtils;
import com.njqg.orchard.library_core.utils.ToastUtils;

/**
 * Created by hans
 * date: 2018/3/1 14:53.
 * e-mail: hxxx1992@163.com
 */

public class UserCenterFVM extends BaseVM<FragmentUserCenterBinding> {
    private String username;


    public UserCenterFVM(Context context, FragmentUserCenterBinding viewBinding) {
        super(context, viewBinding);
    }

    @Override
    protected void init() {
        username = SPUtils.getString(Constant.LOGIN_USER_NAME);

    }

    public void myCollection() {
        LogUtils.e(TAG, "UserCenterFVM myCollection");
        if (!Constant.isLogin) {
            ToastUtils.show("请登陆后再进行操作");
            return;
        }
        context.startActivity(new Intent(context, ColloectionActivity.class));
        LogUtils.e(TAG, "myCollection");
        ToastUtils.show("myCollection");
    }

    public void aboutMe() {
        LogUtils.e(TAG, "aboutMe");
        ToastUtils.show("aboutMe");

    }

    public void login() {
        if (Constant.isLogin) {
            SPUtils.clear(Constant.SP_NAME);
            Constant.isLogin = false;
        } else {
            context.startActivity(new Intent(context, LoginActivity.class));
        }
        LogUtils.e(TAG, "login");
        ToastUtils.show("login");

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
