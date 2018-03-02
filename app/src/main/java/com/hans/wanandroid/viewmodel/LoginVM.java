package com.hans.wanandroid.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.hans.wanandroid.databinding.ActivityLoginBinding;
import com.hans.wanandroid.libpack.BaseVM;
import com.hans.wanandroid.libpack.RetrofitManager;
import com.hans.wanandroid.model.model.LoginModel;
import com.hans.wanandroid.model.pojo.ResponseBean;
import com.hans.wanandroid.model.pojo.UserBean;
import com.hans.wanandroid.net.WanApi;
import com.hans.wanandroid.utils.Constant;
import com.hans.wanandroid.utils.RxUtils;
import com.hans.wanandroid.view.activity.LoginActivity;
import com.njqg.orchard.library_core.net.DefaultObserver;
import com.njqg.orchard.library_core.utils.LogUtils;
import com.njqg.orchard.library_core.utils.SPUtils;
import com.njqg.orchard.library_core.utils.ToastUtils;

/**
 * Created by hans
 * date: 2018/2/28 18:52.
 * e-mail: hxxx1992@163.com
 */

public class LoginVM extends BaseVM<ActivityLoginBinding> {
    String account;
    String password;

    public LoginVM(Context context, ActivityLoginBinding viewBinding) {
        super(context, viewBinding);
    }

    @Override
    protected void init() {
        viewBinding.setLm(new LoginModel());
    }

    public void show() {
        account = viewBinding.getLm().getAccount();
        password = viewBinding.getLm().getPassword();
        LogUtils.e(TAG, "account:" + account + ",password:" + password);
        RetrofitManager.getInstance().create(WanApi.class)
                .requestLogin(account, password)
                .compose(RxUtils.<ResponseBean<UserBean>>applySchedulers())
                .subscribe(new DefaultObserver<ResponseBean<UserBean>>(baseImpl) {
                    @Override
                    protected void doOnNext(ResponseBean<UserBean> userBean) {
                        LogUtils.e(TAG, "userBean:" + userBean.toString());
                        if (userBean.getErrorCode() < 0) {
                            ToastUtils.show("登陆失败");
                            Constant.isLogin = false;
                        } else {
                            ToastUtils.show("登录成功");
                            Constant.isLogin = true;
                            SPUtils.put(Constant.LOGIN_USER_NAME, account);
                            SPUtils.put(Constant.LOGIN_USER_PASSWORD, password);
                            ((LoginActivity) context).finish();
                        }
                    }
                });
    }
}
