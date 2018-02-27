package com.njqg.orchard.library_core.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.njqg.orchard.library_core.view.CustomProgressDialog;
import com.njqg.orchard.library_core.view.CustomProgressDialogHelper;


/**
 * Created by hans
 * date: 2017/11/23 17:22.
 * e-mail: hxxx1992@163.com
 */

public abstract class BaseCoreFragment extends BaseRxFragment {
    protected View rootView;
    protected LayoutInflater inflater;
    protected Activity context;

    private CustomProgressDialog mProgressDialog;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        this.inflater = inflater;
        mProgressDialog = CustomProgressDialogHelper.createDialog(getContext());
        mProgressDialog.setCanceledOnTouchOutside(false);
        if (rootView == null) {
            rootView = inflater.inflate(this.getLayoutId(), container, false);
            initBindView(rootView);
            init();
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }

        return rootView;

    }

    protected abstract void initBindView(View rootView);


    /**
     * 显示ProgressDialog
     */
    @Override
    public void showProgress(String msg) {
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    /**
     * 显示ProgressDialog
     */
    @Override
    public void showProgress() {
        mProgressDialog.show();
    }

    /**
     * 取消ProgressDialog
     */
    @Override
    public void dismissProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    protected abstract int getLayoutId();

    protected abstract void init();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
