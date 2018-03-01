package com.hans.wanandroid.libpack;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;

import com.njqg.orchard.library_core.base.BaseLibLazyFragment;


/**
 * Created by hans
 * date: 2017/11/29 11:27.
 * e-mail: hxxx1992@163.com
 */

public abstract class BaseLazysFragment<T extends ViewDataBinding> extends BaseLibLazyFragment {

    protected T viewBinding;

    @Override
    protected void initBindView(View rootView) {
        viewBinding = DataBindingUtil.bind(rootView);
    }
}
