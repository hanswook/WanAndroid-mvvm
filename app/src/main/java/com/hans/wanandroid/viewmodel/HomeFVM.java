package com.hans.wanandroid.viewmodel;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
import com.hans.wanandroid.utils.ShortTimeUtil;
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
    private boolean isLoading = false;
    private int pageIndex = 0;
    private boolean isNeedLoadMore;

    public HomeFVM(Context context, FragmentHomeBinding viewBinding) {
        super(context, viewBinding);
    }

    @Override
    protected void init() {
        initData();
        initRecy();
        initRecyclerData();
        initViewPagerData();
    }

    private void initRecy() {
        commonAdapter = new MvvmCommonAdapter(context
                , datas, R.layout.card_item_layout, BR.cardItemVM);
        viewBinding.homefRecy.setAdapter(commonAdapter);
        viewBinding.homefRecy.setLayoutManager(new LinearLayoutManager(context));
        viewBinding.homefRecy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LogUtils.e(TAG, "newState:" + newState);
                if (isLoading) {
                    LogUtils.e(TAG, "正在加载哦");
                    return;
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                //判断是当前layoutManager是否为LinearLayoutManager
                // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                    //获取最后一个可见view的位置
                    int lastItemPosition = linearManager.findLastVisibleItemPosition();
                    //获取第一个可见view的位置
                    int firstItemPosition = linearManager.findFirstVisibleItemPosition();
                    LogUtils.e(TAG, "lastItemPosition:" + lastItemPosition);

                    if (lastItemPosition == datas.size() - 1) {
//                        根据滑动间隔，避免多次加载的情况。
                        if (ShortTimeUtil.isFastClick()) {
                            LogUtils.e(TAG, "滑动间隔过短");
                            return;
                        }
                        loadMore();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    private void loadMore() {
        show();
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
        LogUtils.e(TAG, "homefvm initRecyclerData");
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
                LogUtils.e(TAG, "onPageSelected posit2ion:" + position);
                viewBinding.homefBannerCount.setText(String.format(context.getResources().getString(R.string.bannercount_placeholder), (position + 1) + "", bannerDatas.size() + ""));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewBinding.homefBannerCount.setText(String.format(context.getResources().getString(R.string.bannercount_placeholder), "1", bannerDatas.size() + ""));

    }

    private void initData() {
        datas = new ArrayList<>();
        bannerDatas = new ArrayList<>();
        isNeedLoadMore = true;
    }

    public void show() {
        LogUtils.e(TAG, "homefvm show  isNeedLoadMore:" + isNeedLoadMore);
        if (!isNeedLoadMore) {
            return;
        }
        isLoading = true;
        LogUtils.e(TAG, "homefvm show  2");
        RetrofitManager.getInstance().create(WanApi.class)
                .getArticleList(pageIndex)
                .compose(RxUtils.<ResponseBean<DataBean<ArticleBean>>>applySchedulers())
                .subscribe(new CommonSubscriber<ResponseBean<DataBean<ArticleBean>>>(context) {
                    @Override
                    public void onNext(ResponseBean<DataBean<ArticleBean>> dataBeanResponseBean) {
                        pageIndex++;
                        int currentSize = datas.size();
                        if (dataBeanResponseBean != null && dataBeanResponseBean.getData() != null && dataBeanResponseBean.getData().getDatas() != null) {
                            addListData(dataBeanResponseBean.getData().getDatas());
                        }
                        commonAdapter.notifyDataSetChanged();
                        LogUtils.e(TAG, "currentSize:" + currentSize + ",size:" + datas.size());
                        if (datas.size() < currentSize + 20) {
                            isNeedLoadMore = false;
                        }
                        isLoading = false;
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        isLoading = false;
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        isLoading = false;
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
