package com.hans.wanandroid.viewmodel.itemvm;

import android.view.View;

import com.hans.wanandroid.R;
import com.hans.wanandroid.customizeview.IconFontTextView;
import com.hans.wanandroid.model.pojo.ArticleBean;
import com.hans.wanandroid.utils.OpenWebHelper;
import com.njqg.orchard.library_core.utils.LogUtils;

/**
 * Created by hans
 * date: 2018/3/1 16:28.
 * e-mail: hxxx1992@163.com
 */

public class CardItemVM {
    private ArticleBean articleBean;
    private boolean isCollect;

    public ArticleBean getArticleBean() {
        return articleBean;
    }

    public void setArticleBean(ArticleBean ArticleBean) {
        this.articleBean = ArticleBean;
    }

    public CardItemVM(ArticleBean ArticleBean) {
        this.articleBean = ArticleBean;
        isCollect = false;
    }

    public void clickTest(View view) {
        LogUtils.e(view.getClass().getSimpleName(), "CardItemVM clickTest");
        OpenWebHelper.openWeb(view.getContext(), articleBean.getLink());
    }

    public void collect(View view) {
        LogUtils.e(view.getClass().getSimpleName(), "CardItemVM collect");

        if (isCollect) {
            isCollect = false;
            ((IconFontTextView) view).setText(view.getContext().getString(R.string.ic_collect_nor));
            ((IconFontTextView) view).setTextColor(view.getContext().getResources().getColor(R.color.gray_99));
        } else {
            isCollect = true;
            ((IconFontTextView) view).setText(view.getContext().getString(R.string.ic_collect_sel));
            ((IconFontTextView) view).setTextColor(view.getContext().getResources().getColor(R.color.a88_blue));
        }
    }


}
