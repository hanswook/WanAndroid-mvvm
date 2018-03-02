package com.hans.wanandroid.view.activity;

import android.app.Activity;
import android.os.Bundle;

import com.hans.wanandroid.R;
import com.hans.wanandroid.databinding.ActivityColloectionBinding;
import com.hans.wanandroid.libpack.BaseActivity;
import com.hans.wanandroid.viewmodel.CollectionVM;

public class ColloectionActivity extends BaseActivity<ActivityColloectionBinding> {

    private CollectionVM collectionVM;

    @Override
    protected void init() {
        collectionVM = new CollectionVM(context, viewBinding);
        viewBinding.setCollectionVM(collectionVM);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_colloection;
    }
}
