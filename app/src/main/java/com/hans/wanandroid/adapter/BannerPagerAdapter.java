package com.hans.wanandroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hans.wanandroid.view.fragment.BannerFragment;
import com.njqg.orchard.library_core.utils.LogUtils;

import java.util.List;

/**
 * Created by hans
 * date: 2018/2/28 16:31.
 * e-mail: hxxx1992@163.com
 */

public class BannerPagerAdapter extends PagerAdapter {

    public BannerPagerAdapter(List<ImageView> datas) {
        this.datas = datas;
    }

    private List<ImageView> datas;

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LogUtils.e("pageadapter","instantiateItem position:"+position);
        // 把position对应位置的ImageView添加到ViewPager中
        ImageView iv = datas.get(position % datas.size());
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        LogUtils.e("pageadapter","destroyItem position:"+position);
        container.removeView(datas.get(position % datas.size()));
    }
}
