package com.hans.wanandroid.viewmodel;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;

import com.android.databinding.library.baseAdapters.BR;
import com.hans.wanandroid.R;
import com.hans.wanandroid.adapter.CommentPagerAdapter;
import com.hans.wanandroid.adapter.MvvmCommonAdapter;
import com.hans.wanandroid.databinding.FragmentHomeBinding;
import com.hans.wanandroid.libpack.BaseVM;
import com.hans.wanandroid.libpack.RetrofitManager;
import com.hans.wanandroid.model.mock.MockUser;
import com.hans.wanandroid.model.pojo.ArticleBean;
import com.hans.wanandroid.model.pojo.DataBean;
import com.hans.wanandroid.model.pojo.ResponseData;
import com.hans.wanandroid.net.WanApi;
import com.hans.wanandroid.utils.RxUtils;
import com.hans.wanandroid.viewmodel.itemvm.CardItemVM;
import com.njqg.orchard.library_core.net.CommonSubscriber;
import com.njqg.orchard.library_core.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hans
 * date: 2018/3/1 11:04.
 * e-mail: hxxx1992@163.com
 */

public class HomeFVM extends BaseVM<FragmentHomeBinding> {
    private List<CardItemVM> datas;
    private MvvmCommonAdapter commonAdapter;
    int previousPosition = 0;

    public HomeFVM(Context context, FragmentHomeBinding viewBinding) {
        super(context, viewBinding);
    }

    @Override
    protected void init() {
        initData();
        commonAdapter = new MvvmCommonAdapter(context
                , datas, R.layout.card_item_layout, BR.cardItemVM);
        viewBinding.homefRecy.setAdapter(commonAdapter);
        viewBinding.homefRecy.setLayoutManager(new LinearLayoutManager(context));
        initViewPager();
        initRecyclerData();

    }

    private void initRecyclerData() {
        show();
    }


    private void initViewPager() {
        List<MockUser> mockUsers = new ArrayList<>();
        mockUsers.add(new MockUser("ABC", 28, true));
        mockUsers.add(new MockUser("亿人", 34, true));
        mockUsers.add(new MockUser("兵人", 12, true));
        mockUsers.add(new MockUser("钉人", 233, true));
        CommentPagerAdapter<MockUser> commentPagerAdapter = new CommentPagerAdapter<>(mockUsers, R.layout.banner_item_layout, BR.mu);
        viewBinding.homefBannerViewpager.setAdapter(commentPagerAdapter);
        viewBinding.homefBannerViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                LogUtils.e(TAG, "onPageSelected position:" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initData() {
        datas = new ArrayList<>();

    }

    public void show() {
        RetrofitManager.getInstance().create(WanApi.class)
                .getArticleList(0)
                .compose(RxUtils.<ResponseData<DataBean<ArticleBean>>>applySchedulers())
                .subscribe(new CommonSubscriber<ResponseData<DataBean<ArticleBean>>>(context) {
                    @Override
                    public void onNext(ResponseData<DataBean<ArticleBean>> dataBeanResponseData) {
                        if (dataBeanResponseData != null && dataBeanResponseData.getData() != null && dataBeanResponseData.getData().getDatas() != null) {
                            addListData(dataBeanResponseData.getData().getDatas());
                        }
                        commonAdapter.notifyDataSetChanged();
                    }
                });

    }

    private void addListData(List<ArticleBean> netDatas) {
        for (ArticleBean articleBean : netDatas) {
            CardItemVM cardItemVM = new CardItemVM(articleBean);
            datas.add(cardItemVM);
        }
    }

}
