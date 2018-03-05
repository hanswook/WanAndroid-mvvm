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
import com.hans.wanandroid.model.pojo.ArticleBean;
import com.hans.wanandroid.model.pojo.BannerBean;
import com.hans.wanandroid.model.pojo.DataBean;
import com.hans.wanandroid.model.pojo.ResponseBean;
import com.hans.wanandroid.net.WanApi;
import com.hans.wanandroid.utils.RxUtils;
import com.hans.wanandroid.viewmodel.itemvm.BannerItemVM;
import com.hans.wanandroid.viewmodel.itemvm.CardItemVM;
import com.njqg.orchard.library_core.net.CommonSubscriber;
import com.njqg.orchard.library_core.net.DefaultObserver;
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
    private List<BannerItemVM> bannerDatas;
    private MvvmCommonAdapter commonAdapter;
    private CommentPagerAdapter<BannerItemVM> commentPagerAdapter;
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
        initRecyclerData();
        initViewPagerData();
    }

    private void initViewPagerData() {
        RetrofitManager.getInstance().create(WanApi.class)
                .getBannerList()
                .compose(RxUtils.<ResponseBean<List<BannerBean>>>applySchedulers())
                .subscribe(new DefaultObserver<ResponseBean<List<BannerBean>>>(baseImpl) {
                    @Override
                    protected void doOnNext(ResponseBean<List<BannerBean>> listResponseBean) {

                        if (isEmpty(listResponseBean) || isEmpty(listResponseBean.getData())) {
                            return;
                        }
                        LogUtils.e(TAG, "listResponseBean.size:" + listResponseBean.getData().size());
                        for (BannerBean bannerBean : listResponseBean.getData()) {
                            bannerDatas.add(new BannerItemVM(bannerBean));
                        }
                        initViewPager();
                        commentPagerAdapter.notifyDataSetChanged();
                    }
                });
    }

    private void initRecyclerData() {
        show();
    }


    private void initViewPager() {
        commentPagerAdapter = new CommentPagerAdapter<>(bannerDatas, R.layout.banner_item_layout, BR.bannerItemVM);
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
        bannerDatas = new ArrayList<>();
    }

    public void show() {
        RetrofitManager.getInstance().create(WanApi.class)
                .getArticleList(0)
                .compose(RxUtils.<ResponseBean<DataBean<ArticleBean>>>applySchedulers())
                .subscribe(new CommonSubscriber<ResponseBean<DataBean<ArticleBean>>>(context) {
                    @Override
                    public void onNext(ResponseBean<DataBean<ArticleBean>> dataBeanResponseBean) {
                        if (dataBeanResponseBean != null && dataBeanResponseBean.getData() != null && dataBeanResponseBean.getData().getDatas() != null) {
                            addListData(dataBeanResponseBean.getData().getDatas());
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
