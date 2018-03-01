package com.hans.wanandroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by hans
 * date: 2018/3/1 12:15.
 * e-mail: hxxx1992@163.com
 * description:主页fragment切换
 */

public class HomePageAdapter  extends FragmentPagerAdapter{
    private List<Fragment> fragments;

    public HomePageAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
