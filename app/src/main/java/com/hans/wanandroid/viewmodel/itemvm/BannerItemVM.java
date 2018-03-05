package com.hans.wanandroid.viewmodel.itemvm;

import android.content.Intent;
import android.view.View;

import com.hans.wanandroid.model.pojo.BannerBean;
import com.hans.wanandroid.utils.Constant;
import com.hans.wanandroid.view.activity.WebDetailActivity;
import com.njqg.orchard.library_core.image.GlideApp;
import com.njqg.orchard.library_core.utils.LogUtils;

/**
 * Created by hans
 * date: 2018/3/5 14:14.
 * e-mail: hxxx1992@163.com
 */

public class BannerItemVM {

    private BannerBean bannerBean;

    public BannerItemVM(BannerBean bannerBean) {
        this.bannerBean = bannerBean;
    }


    public BannerBean getBannerBean() {
        return bannerBean;
    }

    public void setBannerBean(BannerBean bannerBean) {
        this.bannerBean = bannerBean;
    }

    public void bannerItemClick(View v) {
        LogUtils.e("BannerItemVM", "bannerItemClick");
        Intent intent = new Intent(v.getContext(), WebDetailActivity.class);
        intent.putExtra(Constant.WEB_DETAIL_URL, bannerBean.getUrl());
        v.getContext().startActivity(intent);
    }
}
