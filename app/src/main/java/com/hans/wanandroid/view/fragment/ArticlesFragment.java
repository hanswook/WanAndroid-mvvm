package com.hans.wanandroid.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hans.wanandroid.R;
import com.hans.wanandroid.databinding.FragmentArticlesBinding;
import com.hans.wanandroid.libpack.BaseFragment;
import com.hans.wanandroid.viewmodel.ArticlesFVM;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticlesFragment extends BaseFragment<FragmentArticlesBinding> {

    private ArticlesFVM articlesFVM;

    public ArticlesFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_articles;
    }

    @Override
    protected void init() {
        articlesFVM=new ArticlesFVM(context, viewBinding);
        viewBinding.setArticleFVM(articlesFVM);
    }


}
