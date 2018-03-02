package com.hans.wanandroid.viewmodel.itemvm;

import android.view.View;

import com.hans.wanandroid.R;
import com.hans.wanandroid.customizeview.IconFontTextView;
import com.hans.wanandroid.libpack.RetrofitManager;
import com.hans.wanandroid.model.pojo.CollectBean;
import com.hans.wanandroid.model.pojo.ResponseBean;
import com.hans.wanandroid.net.WanApi;
import com.hans.wanandroid.utils.Constant;
import com.hans.wanandroid.utils.OpenWebHelper;
import com.hans.wanandroid.utils.RxUtils;
import com.njqg.orchard.library_core.net.CommonSubscriber;
import com.njqg.orchard.library_core.utils.LogUtils;
import com.njqg.orchard.library_core.utils.ToastUtils;

/**
 * Created by hans
 * date: 2018/3/1 16:28.
 * e-mail: hxxx1992@163.com
 */

public class CollectionItemVM {
    private CollectBean collectBean;
    private boolean isCollect;

    public boolean isCollect() {
        return isCollect;
    }

    public void setCollect(boolean collect) {
        isCollect = collect;
    }

    public CollectionItemVM(CollectBean collectBean) {
        this.collectBean = collectBean;
        isCollect = true;
    }

    public CollectBean getCollectBean() {
        return collectBean;
    }

    public void setCollectBean(CollectBean collectBean) {
        this.collectBean = collectBean;
    }

    public void clickTest(View view) {
        LogUtils.e(view.getClass().getSimpleName(), "CollectionItemVM clickTest");
        OpenWebHelper.openWeb(view.getContext(), collectBean.getLink());
    }

    public void collect(View view) {
        LogUtils.e(view.getClass().getSimpleName(), "CollectionItemVM collect");
        if (!Constant.isLogin) {
            ToastUtils.show("请登陆后再进行操作");
            return;
        }
        requestCollect(view);
    }

    private void requestCollect(final View view) {
        if (isCollect) {
            RetrofitManager.getInstance().create(WanApi.class)
                    .requestUnCollectInList(collectBean.getOriginId())
                    .compose(RxUtils.<ResponseBean>applySchedulers())
                    .subscribe(new CommonSubscriber<ResponseBean>(view.getContext()) {
                        @Override
                        public void onNext(ResponseBean responseBean) {
                            ToastUtils.show("取消收藏成功" + responseBean.getErrorCode());
                            isCollect = false;
                            ((IconFontTextView) view).setText(view.getContext().getString(R.string.ic_collect_nor));
                            ((IconFontTextView) view).setTextColor(view.getContext().getResources().getColor(R.color.gray_99));
                        }
                    });


        } else {
            RetrofitManager.getInstance().create(WanApi.class)
                    .requestCollect(collectBean.getId())
                    .compose(RxUtils.<ResponseBean>applySchedulers())
                    .subscribe(new CommonSubscriber<ResponseBean>(view.getContext()) {
                        @Override
                        public void onNext(ResponseBean responseBean) {
                            ToastUtils.show("收藏成功" + responseBean.getErrorCode());
                            isCollect = true;
                            ((IconFontTextView) view).setText(view.getContext().getString(R.string.ic_collect_sel));
                            ((IconFontTextView) view).setTextColor(view.getContext().getResources().getColor(R.color.a88_blue));
                        }
                    });

        }
    }


}
