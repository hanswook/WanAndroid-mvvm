package com.njqg.orchard.library_core.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.njqg.orchard.library_core.utils.ToastUtils;
import com.njqg.orchard.library_core.view.CustomProgressDialog;
import com.njqg.orchard.library_core.view.CustomProgressDialogHelper;


public abstract class BaseCoreActivity extends AppCompatActivity implements BaseImpl{
    //  加载进度的dialog
    private CustomProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = CustomProgressDialogHelper.createDialog(this);
        mProgressDialog.setCanceledOnTouchOutside(false);
    }

    public void showToast(String msg){
        ToastUtils.show(msg);
    }

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

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
