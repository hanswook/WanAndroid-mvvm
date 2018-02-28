package com.hans.wanandroid;

import com.hans.wanandroid.databinding.ActivityMainBinding;
import com.hans.wanandroid.libpack.BaseActivity;
import com.hans.wanandroid.libpack.RetrofitManager;
import com.hans.wanandroid.model.pojo.BannerBean;
import com.hans.wanandroid.model.pojo.DataBean;
import com.hans.wanandroid.model.pojo.DatasBean;
import com.hans.wanandroid.model.pojo.WanBean;
import com.hans.wanandroid.net.WanApi;
import com.hans.wanandroid.utils.Constant;
import com.hans.wanandroid.utils.RxUtils;
import com.hans.wanandroid.viewmodel.MainVM;
import com.njqg.orchard.library_core.net.DefaultObserver;
import com.njqg.orchard.library_core.utils.LogUtils;
import com.njqg.orchard.library_core.utils.SPUtils;

import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding> {


    private MainVM mainVM;

    @Override
    protected void init() {
        mainVM = new MainVM(context, viewBinding);
        viewBinding.setVm(mainVM);
        mainVM.setMainActivity(this);
//        testLogin();\
        clearSP();

    }

    private void clearSP() {
        SPUtils.clear(Constant.SP_NAME);
    }

    private void testLogin() {
        RetrofitManager.getInstance().create(WanApi.class)
                .requestLogin("hanswook", "hanxu921001")
                .compose(RxUtils.applySchedulers())
                .subscribe(new DefaultObserver<Object>(this) {
                    @Override
                    protected void doOnNext(Object o) {
                        LogUtils.e(TAG, "o:" + o.toString());
                    }
                });
    }

    private void test1() {
        RetrofitManager.getInstance().create(WanApi.class)
                .getBannerList()

                .compose(RxUtils.<WanBean<List<BannerBean>>>applySchedulers())
                .subscribe(new DefaultObserver<WanBean<List<BannerBean>>>(this) {
                    @Override
                    protected void doOnNext(WanBean<List<BannerBean>> listWanBean) {
                        LogUtils.e(TAG, "listWanBean getErrorMsg:" + listWanBean.getErrorMsg());
                        LogUtils.e(TAG, "listWanBean getErrorCode:" + listWanBean.getErrorCode());
                        if (listWanBean.getData() != null)
                            LogUtils.e(TAG, "listWanBean getData:" + listWanBean.getData().size());

                    }
                });
    }

    private void test() {
        RetrofitManager.getInstance().create(WanApi.class)
                .getArticleList(0)
                .compose(RxUtils.<WanBean<DataBean<DatasBean>>>applySchedulers())
                .subscribe(new DefaultObserver<WanBean<DataBean<DatasBean>>>(this) {
                    @Override
                    protected void doOnNext(WanBean<DataBean<DatasBean>> datasBean) {
                        LogUtils.e(TAG, "datasBean getErrorMsg:" + datasBean.getErrorMsg());
                        LogUtils.e(TAG, "datasBean getErrorCode:" + datasBean.getErrorCode());
                        if (datasBean != null && datasBean.getData().getDatas() != null)
                            LogUtils.e(TAG, "datasBean size:" + datasBean.getData().getDatas().size());
                    }
                });
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


}
