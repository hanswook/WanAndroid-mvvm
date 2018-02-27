package com.hans.wanandroid.view.activity;


import com.hans.wanandroid.R;
import com.hans.wanandroid.databinding.ActivityHomeBinding;
import com.hans.wanandroid.libpack.BaseActivity;
import com.hans.wanandroid.viewmodel.HomeVm;

public class HomeActivity extends BaseActivity<ActivityHomeBinding> {

    private HomeVm homeVm;

    @Override
    protected void init() {
        homeVm = new HomeVm(context, viewBinding);
        viewBinding.setVm(homeVm);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }
}
