package com.hans.wanandroid.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hans.wanandroid.R;
import com.hans.wanandroid.databinding.FragmentUserCenterBinding;
import com.hans.wanandroid.libpack.BaseFragment;
import com.hans.wanandroid.viewmodel.UserCenterFVM;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserCenterFragment extends BaseFragment<FragmentUserCenterBinding> {

    private UserCenterFVM userCenterFVM;

    public UserCenterFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_center;
    }

    @Override
    protected void init() {
        userCenterFVM = new UserCenterFVM(context, viewBinding);
        viewBinding.setUserCenterFVM(userCenterFVM);
    }

    @Override
    public void onResume() {
        super.onResume();
        userCenterFVM.refreshLoginStatus();

    }
}
