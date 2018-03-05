package com.hans.wanandroid.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.util.Pools;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by hans
 * date: 2018/2/28 17:39.
 * e-mail: hxxx1992@163.com
 */

public class CommentPagerAdapter<D> extends PagerAdapter {
    private List<D> list;
    private int layoutId;
    private int variableId;
    private Pools.Pool<View> pool = new Pools.SimplePool<>(4);

    //自己造一个池，可以提高加载效率，与复用率，
    public CommentPagerAdapter(List<D> list, int layoutId, int variableId) {
        this.list = list;
        this.layoutId = layoutId;
        this.variableId = variableId;
    }

    @Override
    public int getCount() {
//        return list.size();
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (list.size() > 0) {
            View view = pool.acquire();
            if (view == null) {
                view = DataBindingUtil.inflate(LayoutInflater.from(container.getContext()), layoutId, container, false).getRoot();
            }
            ViewDataBinding bind = DataBindingUtil.bind(view);
            bind.setVariable(variableId, list.get(position % list.size()));
            container.addView(view);
            return view;
        }
        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
        pool.release(view);
    }
}
