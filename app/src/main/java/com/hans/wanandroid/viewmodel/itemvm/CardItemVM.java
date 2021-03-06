package com.hans.wanandroid.viewmodel.itemvm;

import android.view.View;

import com.hans.wanandroid.R;
import com.hans.wanandroid.customizeview.IconFontTextView;
import com.hans.wanandroid.libpack.RetrofitManager;
import com.hans.wanandroid.model.pojo.ArticleBean;
import com.hans.wanandroid.model.pojo.CollectBean;
import com.hans.wanandroid.model.pojo.DataBean;
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

public class CardItemVM {
    private ArticleBean articleBean;

    public ArticleBean getArticleBean() {
        return articleBean;
    }

    public void setArticleBean(ArticleBean ArticleBean) {
        this.articleBean = ArticleBean;
    }

    public CardItemVM(ArticleBean ArticleBean) {
        this.articleBean = ArticleBean;
    }

    public void clickTest(View view) {
        LogUtils.e(view.getClass().getSimpleName(), "CardItemVM clickTest");
        OpenWebHelper.openWeb(view.getContext(), articleBean.getLink());
    }

    public void collect(View view) {
        LogUtils.e(view.getClass().getSimpleName(), "CardItemVM collect");
        if (!Constant.isLogin) {
            ToastUtils.show("请登陆后再进行操作");
            return;
        }
        requestCollect(view);
    }

    private void requestCollect(final View view) {
        if (articleBean.isCollect()) {
            RetrofitManager.getInstance().create(WanApi.class)
                    .requestUnCollectInList(articleBean.getId())
                    .compose(RxUtils.<ResponseBean>applySchedulers())
                    .subscribe(new CommonSubscriber<ResponseBean>(view.getContext()) {
                        @Override
                        public void onNext(ResponseBean responseBean) {
                            ToastUtils.show("取消收藏成功"+responseBean.getErrorCode());
                            articleBean.setCollect(false);
                            ((IconFontTextView) view).setText(view.getContext().getString(R.string.ic_collect_nor));
                            ((IconFontTextView) view).setTextColor(view.getContext().getResources().getColor(R.color.gray_99));
                        }
                    });


        } else {
            RetrofitManager.getInstance().create(WanApi.class)
                    .requestCollect(articleBean.getId())
                    .compose(RxUtils.<ResponseBean>applySchedulers())
                    .subscribe(new CommonSubscriber<ResponseBean>(view.getContext()) {
                        @Override
                        public void onNext(ResponseBean responseBean) {
                            ToastUtils.show("收藏成功"+responseBean.getErrorCode());
                            articleBean.setCollect(true);
                            ((IconFontTextView) view).setText(view.getContext().getString(R.string.ic_collect_sel));
                            ((IconFontTextView) view).setTextColor(view.getContext().getResources().getColor(R.color.a88_blue));
                        }
                    });

        }
    }


}
