package com.hans.wanandroid.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hans
 * date: 2018/1/15 10:53.
 * e-mail: hxxx1992@163.com
 */

public class CommonHolder extends RecyclerView.ViewHolder{

    private ViewDataBinding viewBinding;

    public CommonHolder(View itemView) {
        super(itemView);
    }

    public ViewDataBinding getViewBinding() {
        return viewBinding;
    }

    public void setViewBinding(ViewDataBinding viewBinding) {
        this.viewBinding = viewBinding;
    }
}

