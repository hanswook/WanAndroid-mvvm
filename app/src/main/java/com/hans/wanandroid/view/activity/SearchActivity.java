package com.hans.wanandroid.view.activity;

import android.app.Activity;
import android.os.Bundle;

import com.hans.wanandroid.R;
import com.hans.wanandroid.databinding.ActivitySearchBinding;
import com.hans.wanandroid.libpack.BaseActivity;
import com.hans.wanandroid.viewmodel.SearchVM;

public class SearchActivity extends BaseActivity<ActivitySearchBinding> {

    private SearchVM searchVM;

    @Override
    protected void init() {
        searchVM = new SearchVM(context, viewBinding);
        viewBinding.setSearchVM(searchVM);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }
}
