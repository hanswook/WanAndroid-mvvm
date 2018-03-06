package com.hans.wanandroid.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hans.wanandroid.R;
import com.hans.wanandroid.databinding.FragmentHomeBinding;
import com.hans.wanandroid.libpack.BaseFragment;
import com.hans.wanandroid.viewmodel.HomeFVM;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<FragmentHomeBinding> {


    private HomeFVM homeFVM;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {
        homeFVM = new HomeFVM(context, viewBinding);
        viewBinding.setHomeFVM(homeFVM);

    }

    @Override
    public void onResume() {
        super.onResume();
        viewBinding.homefBannerViewpager.requestFocus();
    }
}
