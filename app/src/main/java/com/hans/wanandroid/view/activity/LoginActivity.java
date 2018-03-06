package com.hans.wanandroid.view.activity;

import android.app.Activity;
import android.os.Bundle;

import com.hans.wanandroid.R;
import com.hans.wanandroid.databinding.ActivityLoginBinding;
import com.hans.wanandroid.libpack.BaseActivity;
import com.hans.wanandroid.viewmodel.LoginVM;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    private LoginVM loginVM;

    @Override
    protected void init() {
        loginVM = new LoginVM(context, viewBinding);
        viewBinding.setLvm(loginVM);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
