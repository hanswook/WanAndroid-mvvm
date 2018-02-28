package com.hans.wanandroid.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hans.wanandroid.R;
import com.hans.wanandroid.databinding.FragmentBannerBinding;
import com.hans.wanandroid.libpack.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BannerFragment extends BaseFragment<FragmentBannerBinding> {


    public BannerFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_banner;
    }

    @Override
    protected void init() {

    }

}
