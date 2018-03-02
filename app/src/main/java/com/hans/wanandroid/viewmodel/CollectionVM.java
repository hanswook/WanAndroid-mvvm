package com.hans.wanandroid.viewmodel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.hans.wanandroid.BR;
import com.hans.wanandroid.R;
import com.hans.wanandroid.adapter.MvvmCommonAdapter;
import com.hans.wanandroid.databinding.ActivityColloectionBinding;
import com.hans.wanandroid.libpack.BaseVM;
import com.hans.wanandroid.libpack.RetrofitManager;
import com.hans.wanandroid.model.pojo.CollectBean;
import com.hans.wanandroid.model.pojo.DataBean;
import com.hans.wanandroid.model.pojo.ResponseBean;
import com.hans.wanandroid.net.WanApi;
import com.hans.wanandroid.utils.RxUtils;
import com.njqg.orchard.library_core.net.CommonSubscriber;
import com.njqg.orchard.library_core.net.DefaultObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hans
 * date: 2018/3/2 17:08.
 * e-mail: hxxx1992@163.com
 */

public class CollectionVM extends BaseVM<ActivityColloectionBinding> {

    private List<CollectBean> collectionDatas;
    private MvvmCommonAdapter commonAdapter;

    public CollectionVM(Context context, ActivityColloectionBinding viewBinding) {
        super(context, viewBinding);
    }

    @Override
    protected void init() {
        collectionDatas = new ArrayList<>();
        commonAdapter = new MvvmCommonAdapter(context, collectionDatas, R.layout.collection_item_layout, BR.collectionItemVM);
        viewBinding.collectionRecycler.setAdapter(commonAdapter);
        viewBinding.collectionRecycler.setLayoutManager(new LinearLayoutManager(context));
        initCollectionData();
    }

    private void initCollectionData() {
        RetrofitManager.getInstance().create(WanApi.class)
                .requestCollectList()
                .compose(RxUtils.<ResponseBean<DataBean<CollectBean>>>applySchedulers())
                .subscribe(new DefaultObserver<ResponseBean<DataBean<CollectBean>>>(baseImpl) {
                    @Override
                    protected void doOnNext(ResponseBean<DataBean<CollectBean>> dataBeanResponseBean) {
                        if (isEmpty(dataBeanResponseBean) || isEmpty(dataBeanResponseBean.getData()) || isEmpty(dataBeanResponseBean.getData().getDatas())) {
                            return;
                        }
                        collectionDatas.addAll(dataBeanResponseBean.getData().getDatas());
                        commonAdapter.notifyDataSetChanged();
                    }
                });
    }
}
