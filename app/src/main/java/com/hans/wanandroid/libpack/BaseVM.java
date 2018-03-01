package com.hans.wanandroid.libpack;

import android.content.Context;
import android.databinding.ViewDataBinding;

import com.njqg.orchard.library_core.base.BaseImpl;

/**
 * Created by hans
 * date: 2017/12/14 20:44.
 * e-mail: hxxx1992@163.com
 */

public abstract class BaseVM<T extends ViewDataBinding> {
    protected Context context;
    protected BaseImpl baseImpl;
    protected String TAG;
    protected T viewBinding;

    public BaseVM(Context context, T viewBinding) {
        this.context = context;
        this.baseImpl = (BaseImpl) context;
        this.viewBinding = viewBinding;
        initTAG();
        init();
    }

    protected abstract void init();

    protected void initTAG() {
        TAG = context.getClass().getSimpleName();
    }

    public T getViewBinding() {
        return viewBinding;
    }

    public void setViewBinding(T viewBinding) {
        this.viewBinding = viewBinding;
    }

    protected boolean isEmpty(Object o) {
        return null == o;
    }
}
