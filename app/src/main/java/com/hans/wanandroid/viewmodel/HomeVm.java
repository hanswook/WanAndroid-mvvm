package com.hans.wanandroid.viewmodel;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.hans.wanandroid.R;
import com.hans.wanandroid.adapter.HomePageAdapter;
import com.hans.wanandroid.databinding.ActivityHomeBinding;
import com.hans.wanandroid.libpack.BaseVM;
import com.hans.wanandroid.view.activity.HomeActivity;
import com.hans.wanandroid.view.fragment.ArticlesFragment;
import com.hans.wanandroid.view.fragment.HomeFragment;
import com.hans.wanandroid.view.fragment.UserCenterFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hans
 * date: 2018/2/27 17:56.
 * e-mail: hxxx1992@163.com
 */

public class HomeVm extends BaseVM<ActivityHomeBinding> {

    private HomePageAdapter fragmentPagerAdapter;
    private List<Fragment> fragments;

    public HomeVm(Context context, ActivityHomeBinding viewBinding) {
        super(context, viewBinding);
    }

    @Override
    protected void init() {
        initTabLayout();
        initFragments();
        initViewPager();

    }

    private void initTabLayout() {
        viewBinding.homeTablayout.setTabMode(TabLayout.MODE_FIXED);
        viewBinding.homeTablayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new ArticlesFragment());
        fragments.add(new UserCenterFragment());
    }

    private void initViewPager() {
        fragmentPagerAdapter = new HomePageAdapter(((HomeActivity) context).getSupportFragmentManager(), fragments);
        viewBinding.homeViewpager.setAdapter(fragmentPagerAdapter);
        viewBinding.homeTablayout.setupWithViewPager(viewBinding.homeViewpager);
        viewBinding.homeTablayout.getTabAt(0).setIcon(R.mipmap.ic_launcher).setText("首页");
        viewBinding.homeTablayout.getTabAt(1).setIcon(R.mipmap.wan_android).setText("文章类别");
        viewBinding.homeTablayout.getTabAt(2).setIcon(R.mipmap.ic_launcher).setText("我的");
    }


}
