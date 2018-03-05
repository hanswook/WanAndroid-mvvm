package com.hans.wanandroid.viewmodel;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.hans.wanandroid.BR;
import com.hans.wanandroid.R;
import com.hans.wanandroid.adapter.MvvmCommonAdapter;
import com.hans.wanandroid.databinding.FragmentArticlesBinding;
import com.hans.wanandroid.libpack.BaseVM;
import com.hans.wanandroid.libpack.RetrofitManager;
import com.hans.wanandroid.model.pojo.DataBean;
import com.hans.wanandroid.model.pojo.ResponseBean;
import com.hans.wanandroid.model.pojo.TreeBean;
import com.hans.wanandroid.model.pojo.ArticleBean;
import com.hans.wanandroid.net.WanApi;
import com.hans.wanandroid.utils.RxUtils;
import com.hans.wanandroid.viewmodel.itemvm.CardItemVM;
import com.njqg.orchard.library_core.net.DefaultObserver;
import com.njqg.orchard.library_core.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hans
 * date: 2018/3/1 13:56.
 * e-mail: hxxx1992@163.com
 */


public class ArticlesFVM extends BaseVM<FragmentArticlesBinding> {

    private List<TreeBean<TreeBean>> articlesData;
    private List<CardItemVM> recyclerData;

    private MvvmCommonAdapter recyclerAdapter;
    private int primaryPosition = 0;


    public ArticlesFVM(Context context, FragmentArticlesBinding viewBinding) {
        super(context, viewBinding);
    }

    @Override
    protected void init() {
        initData();
        requestTabsData();
        initTabLayout();
        initRecyclerAdapter();
    }

    private void initRecyclerAdapter() {
        recyclerAdapter = new MvvmCommonAdapter(context, recyclerData, R.layout.card_item_layout, BR.cardItemVM);
        viewBinding.articlesRecycler.setAdapter(recyclerAdapter);
        viewBinding.articlesRecycler.setLayoutManager(new LinearLayoutManager(context));
    }

    private void requestTabsData() {
        RetrofitManager.getInstance().create(WanApi.class)
                .getTreeList()
                .compose(RxUtils.<ResponseBean<List<TreeBean<TreeBean>>>>applySchedulers())
                .subscribe(new DefaultObserver<ResponseBean<List<TreeBean<TreeBean>>>>(baseImpl) {
                    @Override
                    protected void doOnNext(ResponseBean<List<TreeBean<TreeBean>>> listResponseBean) {
                        if (null == listResponseBean || listResponseBean.getErrorCode() < 0) {
                            return;
                        }
                        articlesData.addAll(listResponseBean.getData());
                        listResponseBean.getData().size();
                        initPrimaryTabLayout(listResponseBean.getData());
//                        initSecondTabLayout(listResponseBean.getData().get(0).getChildren());
//                        initRecyclerData(listResponseBean.getData().get(0).getChildren().get(0));
                    }
                });
    }

    private void initRecyclerData(TreeBean TreeBean) {
        RetrofitManager.getInstance().create(WanApi.class)
                .getTreeDetailList(0, TreeBean.getId())
                .compose(RxUtils.<ResponseBean<DataBean<ArticleBean>>>applySchedulers())
                .subscribe(new DefaultObserver<ResponseBean<DataBean<ArticleBean>>>(baseImpl) {
                    @Override
                    protected void doOnNext(ResponseBean<DataBean<ArticleBean>> dataBeanResponseBean) {
                        if (isEmpty(dataBeanResponseBean)) {
                            return;
                        }
                        LogUtils.e(TAG, "initRecyclerData doOnNext dataBeanResponseBean size:" + dataBeanResponseBean.getData().getDatas().size());
                        recyclerData.clear();
                        for (ArticleBean ArticleBean : dataBeanResponseBean.getData().getDatas()) {
                            recyclerData.add(new CardItemVM(ArticleBean));
                        }
                        LogUtils.e(TAG, "recyclerData size：" + recyclerData.size());
                        recyclerAdapter.notifyDataSetChanged();

                    }
                });
    }

    private void initSecondTabLayout(List<TreeBean> children) {
        viewBinding.articlesTablayoutSecond.removeAllTabs();
        for (int i = 0; i < children.size(); i++) {
            viewBinding.articlesTablayoutSecond.addTab(viewBinding.articlesTablayoutSecond.newTab().setText(children.get(i).getName()));
        }
    }


    private void initPrimaryTabLayout(List<TreeBean<TreeBean>> data) {
        for (int i = 0; i < data.size(); i++) {
            viewBinding.articlesTablayout.addTab(viewBinding.articlesTablayout.newTab().setText(data.get(i).getName()));
        }
    }

    private void initData() {
        articlesData = new ArrayList<>();
        recyclerData = new ArrayList<>();
    }

    private void initTabLayout() {
        viewBinding.articlesTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewBinding.articlesTablayoutSecond.setTabMode(TabLayout.MODE_SCROLLABLE);

        viewBinding.articlesTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                LogUtils.e(TAG, "articlesTablayout onTabSelected tab:" + tab.getPosition());
                initSecondTabLayout(articlesData.get(tab.getPosition()).getChildren());
                primaryPosition = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewBinding.articlesTablayoutSecond.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                LogUtils.e(TAG, "articlesTablayoutSecond onTabSelected tab:" + tab.getPosition());
                initRecyclerData(articlesData.get(primaryPosition).getChildren().get(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
