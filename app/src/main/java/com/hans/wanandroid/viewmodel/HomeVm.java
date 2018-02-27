package com.hans.wanandroid.viewmodel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.android.databinding.library.baseAdapters.BR;
import com.hans.wanandroid.R;
import com.hans.wanandroid.adapter.MvvmCommonAdapter;
import com.hans.wanandroid.databinding.ActivityHomeBinding;
import com.hans.wanandroid.libpack.BaseVM;
import com.hans.wanandroid.libpack.RetrofitManager;
import com.hans.wanandroid.model.entity.DataBean;
import com.hans.wanandroid.model.entity.DatasBean;
import com.hans.wanandroid.model.entity.WanBean;
import com.hans.wanandroid.model.mock.MockUser;
import com.hans.wanandroid.net.WanApi;
import com.hans.wanandroid.utils.RxUtils;
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

    private List<DatasBean> datas;
    private MvvmCommonAdapter commonAdapter;

    public HomeVm(Context context, ActivityHomeBinding viewBinding) {
        super(context, viewBinding);
    }

    @Override
    protected void init() {
        initData();
        commonAdapter = new MvvmCommonAdapter(context
                , datas, R.layout.home_list_layout, BR.dbvm);
        viewBinding.homeRecy.setAdapter(commonAdapter);
        viewBinding.homeRecy.setLayoutManager(new LinearLayoutManager(context));

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
                            datas.addAll(dataBeanWanBean.getData().getDatas());
                        }
                        commonAdapter.notifyDataSetChanged();
                    }
                });

    }
}
