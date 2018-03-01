package com.hans.wanandroid.viewmodel;

import android.content.Context;
import android.util.Log;

import com.hans.wanandroid.databinding.FragmentUserCenterBinding;
import com.hans.wanandroid.libpack.BaseVM;
import com.njqg.orchard.library_core.utils.LogUtils;
import com.njqg.orchard.library_core.utils.ToastUtils;

/**
 * Created by hans
 * date: 2018/3/1 14:53.
 * e-mail: hxxx1992@163.com
 */

public class UserCenterFVM extends BaseVM<FragmentUserCenterBinding> {

    public UserCenterFVM(Context context, FragmentUserCenterBinding viewBinding) {
        super(context, viewBinding);
    }

    @Override
    protected void init() {

    }

    public void myCollection() {
        LogUtils.e(TAG,"myCollection");
        ToastUtils.show("myCollection");
    }

    public void aboutMe() {
        LogUtils.e(TAG,"aboutMe");
        ToastUtils.show("aboutMe");

    }

    public void login() {
        LogUtils.e(TAG,"login");
        ToastUtils.show("login");

    }


}
