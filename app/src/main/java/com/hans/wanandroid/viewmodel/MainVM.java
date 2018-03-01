package com.hans.wanandroid.viewmodel;

import android.content.Context;

import com.hans.wanandroid.MainActivity;
import com.hans.wanandroid.databinding.ActivityMainBinding;
import com.hans.wanandroid.libpack.BaseVM;
import com.hans.wanandroid.libpack.RetrofitManager;
import com.hans.wanandroid.model.pojo.CollectBean;
import com.hans.wanandroid.model.pojo.DataBean;
import com.hans.wanandroid.model.pojo.ResponseData;
import com.hans.wanandroid.net.WanApi;
import com.hans.wanandroid.utils.RxUtils;
import com.njqg.orchard.library_core.net.DefaultObserver;
import com.njqg.orchard.library_core.utils.LogUtils;

/**
 * Created by hans
 * date: 2018/2/27 14:47.
 * e-mail: hxxx1992@163.com
 */

public class MainVM extends BaseVM<ActivityMainBinding> {

    public MainVM(Context context, ActivityMainBinding viewBinding) {
        super(context, viewBinding);
    }

    private MainActivity mainActivity;

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected void init() {

    }


    public void subTest() {


    }

    public void requestCollect() {
        RetrofitManager.getInstance().create(WanApi.class)
                .requestCollect()
                .compose(RxUtils.<ResponseData<DataBean<CollectBean>>>applySchedulers())
                .subscribe(new DefaultObserver<ResponseData<DataBean<CollectBean>>>(getMainActivity()) {
                    @Override
                    protected void doOnNext(ResponseData<DataBean<CollectBean>> dataBeanResponseData) {
                        LogUtils.e(TAG, "dataBeanResponseData getErrorCode:" + dataBeanResponseData.getErrorCode());
                        LogUtils.e(TAG, "dataBeanResponseData getErrorMsg:" + dataBeanResponseData.getErrorMsg());

                        if (dataBeanResponseData.getData() != null)
                            LogUtils.e(TAG, "dataBeanResponseData getDatas:" + dataBeanResponseData.getData().getDatas().size());


                    }
                });

    }

    public void login() {
        RetrofitManager.getInstance().create(WanApi.class)
                .requestLogin("hanswook", "hanxu921001")
                .compose(RxUtils.applySchedulers())
                .subscribe(new DefaultObserver<Object>(getMainActivity()) {
                    @Override
                    protected void doOnNext(Object o) {
                        LogUtils.e(TAG, "o:" + o.toString());
                    }
                });
    }
}
