package com.hans.wanandroid.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.hans.wanandroid.databinding.ActivityLoginBinding;
import com.hans.wanandroid.libpack.BaseVM;
import com.hans.wanandroid.libpack.RetrofitManager;
import com.hans.wanandroid.model.model.LoginModel;
import com.hans.wanandroid.net.WanApi;
import com.hans.wanandroid.utils.RxUtils;
import com.njqg.orchard.library_core.net.DefaultObserver;
import com.njqg.orchard.library_core.utils.LogUtils;

/**
 * Created by hans
 * date: 2018/2/28 18:52.
 * e-mail: hxxx1992@163.com
 */

public class LoginVM extends BaseVM<ActivityLoginBinding> {


    public LoginVM(Context context, ActivityLoginBinding viewBinding) {
        super(context, viewBinding);
    }

    @Override
    protected void init() {
        viewBinding.setLm(new LoginModel());
    }

    public void show() {
        String account=viewBinding.getLm().getAccount();
        String password=viewBinding.getLm().getPassword();
        LogUtils.e(TAG, "account:" + account + ",password:" + password);
        RetrofitManager.getInstance().create(WanApi.class)
                .requestLogin(account,password)
                .compose(RxUtils.applySchedulers())
                .subscribe(new DefaultObserver<Object>(baseImpl) {
                    @Override
                    protected void doOnNext(Object o) {
                        LogUtils.e(TAG,"0:"+o);
                    }
                });
    }
}
