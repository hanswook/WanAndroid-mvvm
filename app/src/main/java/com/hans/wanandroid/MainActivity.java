package com.hans.wanandroid;

import com.hans.wanandroid.databinding.ActivityMainBinding;
import com.hans.wanandroid.libpack.BaseActivity;
import com.hans.wanandroid.libpack.RetrofitManager;
import com.hans.wanandroid.model.pojo.BannerBean;
import com.hans.wanandroid.model.pojo.DataBean;
import com.hans.wanandroid.model.pojo.ArticleBean;
import com.hans.wanandroid.model.pojo.ResponseBean;
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

    }

    private void test1() {
        RetrofitManager.getInstance().create(WanApi.class)
                .getBannerList()

                .compose(RxUtils.<ResponseBean<List<BannerBean>>>applySchedulers())
                .subscribe(new DefaultObserver<ResponseBean<List<BannerBean>>>(this) {
                    @Override
                    protected void doOnNext(ResponseBean<List<BannerBean>> listResponseBean) {
                        LogUtils.e(TAG, "listResponseBean getErrorMsg:" + listResponseBean.getErrorMsg());
                        LogUtils.e(TAG, "listResponseBean getErrorCode:" + listResponseBean.getErrorCode());
                        if (listResponseBean.getData() != null)
                            LogUtils.e(TAG, "listResponseBean getData:" + listResponseBean.getData().size());

                    }
                });
    }

    private void test() {
        RetrofitManager.getInstance().create(WanApi.class)
                .getArticleList(0)
                .compose(RxUtils.<ResponseBean<DataBean<ArticleBean>>>applySchedulers())
                .subscribe(new DefaultObserver<ResponseBean<DataBean<ArticleBean>>>(this) {
                    @Override
                    protected void doOnNext(ResponseBean<DataBean<ArticleBean>> datasBean) {
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
