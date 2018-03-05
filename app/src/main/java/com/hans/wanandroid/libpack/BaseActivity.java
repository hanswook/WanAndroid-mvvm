package com.hans.wanandroid.libpack;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

import com.njqg.orchard.library_core.base.BaseLibActivity;


/**
 * Created by hans
 * date: 2017/11/29 11:13.
 * e-mail: hxxx1992@163.com
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends BaseLibActivity {

    protected T viewBinding;

    @Override
    protected void initBindView() {
        viewBinding = DataBindingUtil.setContentView(this, getLayoutId());
        DataBindingUtil.setDefaultComponent(new WanComponent());
    }


}
