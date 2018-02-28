package com.hans.wanandroid.viewmodel;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.android.databinding.library.baseAdapters.BR;
import com.hans.wanandroid.R;
import com.hans.wanandroid.adapter.BannerPagerAdapter;
import com.hans.wanandroid.adapter.CommentPagerAdapter;
import com.hans.wanandroid.adapter.MvvmCommonAdapter;
import com.hans.wanandroid.databinding.ActivityHomeBinding;
import com.hans.wanandroid.libpack.BaseVM;
import com.hans.wanandroid.libpack.RetrofitManager;
import com.hans.wanandroid.model.mock.MockUser;
import com.hans.wanandroid.model.model.HomeListModel;
import com.hans.wanandroid.model.pojo.DataBean;
import com.hans.wanandroid.model.pojo.DatasBean;
import com.hans.wanandroid.model.pojo.WanBean;
import com.hans.wanandroid.net.WanApi;
import com.hans.wanandroid.utils.RxUtils;
import com.hans.wanandroid.view.activity.HomeActivity;
import com.hans.wanandroid.view.fragment.BannerFragment;
import com.njqg.orchard.library_core.image.GlideApp;
import com.njqg.orchard.library_core.net.CommonSubscriber;
import com.njqg.orchard.library_core.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hans
 * date: 2018/2/27 17:56.
 * e-mail: hxxx1992@163.com
 */

public class HomeVm extends BaseVM<ActivityHomeBinding> {

    private List<HomeListModel> datas;
    private MvvmCommonAdapter commonAdapter;
    int previousPosition = 0;

    public HomeVm(Context context, ActivityHomeBinding viewBinding) {
        super(context, viewBinding);
    }

    @Override
    protected void init() {
        initData();
        commonAdapter = new MvvmCommonAdapter(context
                , datas, R.layout.home_list_layout, BR.hlm);
        viewBinding.homeRecy.setAdapter(commonAdapter);
        viewBinding.homeRecy.setLayoutManager(new LinearLayoutManager(context));
        initViewPager();


    }

    private void initViewPager() {
        List<MockUser> mockUsers = new ArrayList<>();
        mockUsers.add(new MockUser("ABC", 28, true));
        mockUsers.add(new MockUser("亿人", 34, true));
        mockUsers.add(new MockUser("兵人", 12, true));
        mockUsers.add(new MockUser("钉人", 233, true));
        CommentPagerAdapter<MockUser> commentPagerAdapter = new CommentPagerAdapter<>(mockUsers, R.layout.banner_item_layout, BR.mu);
        viewBinding.homeViewpager.setAdapter(commentPagerAdapter);
        viewBinding.homeViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
                .compose(RxUtils.<WanBean<DataBean<DatasBean>>>applySchedulers())
                .subscribe(new CommonSubscriber<WanBean<DataBean<DatasBean>>>(context) {
                    @Override
                    public void onNext(WanBean<DataBean<DatasBean>> dataBeanWanBean) {
                        if (dataBeanWanBean != null && dataBeanWanBean.getData() != null && dataBeanWanBean.getData().getDatas() != null) {
                            addListData(dataBeanWanBean.getData().getDatas());
                        }
                        commonAdapter.notifyDataSetChanged();
                    }
                });

    }

    private void addListData(List<DatasBean> netDatas) {
        for (DatasBean datasBean : netDatas) {
            HomeListModel homeListModel = new HomeListModel();
            homeListModel.setTitle(datasBean.getTitle());
            homeListModel.setDesc(context.getString(R.string.item_author) + datasBean.getAuthor() + context.getString(R.string.item_space) +
                    context.getString(R.string.item_type) + datasBean.getChapterName() + context.getString(R.string.item_space)
                    + context.getString(R.string.item_time) + datasBean.getPublishTime());
            homeListModel.setDatasBean(datasBean);
            datas.add(homeListModel);
        }
    }
}
