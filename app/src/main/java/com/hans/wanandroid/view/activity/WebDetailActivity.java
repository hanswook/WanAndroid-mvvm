package com.hans.wanandroid.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.hans.wanandroid.R;
import com.hans.wanandroid.databinding.ActivityWebDetailBinding;
import com.hans.wanandroid.libpack.BaseActivity;
import com.hans.wanandroid.utils.Constant;
import com.njqg.orchard.library_core.utils.LogUtils;

public class WebDetailActivity extends BaseActivity<ActivityWebDetailBinding> {


    private WebView webDetailView;

    private String webUrl = "";

    @Override
    protected void init() {
        initWebView();
        initWebViewSetting();
        initIntentData();

    }

    private void initIntentData() {
        webUrl = getIntent().getStringExtra(Constant.WEB_DETAIL_URL);
        LogUtils.e(TAG, "weburl:" + webUrl);
        if (null == webUrl || webUrl.equalsIgnoreCase("")) {
            return;
        }
        webDetailView.loadUrl(webUrl);
    }

    private void initWebViewSetting() {
        WebSettings settings = webDetailView.getSettings();

        webDetailView.setWebChromeClient(new WebChromeClient());
        webDetailView.setWebViewClient(new WebViewClient());

        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setBlockNetworkImage(false);
        settings.setDomStorageEnabled(true);

        //开启缓存
        settings.setAppCacheEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);

    }

    private void initWebView() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        webDetailView = new WebView(getApplicationContext());
        webDetailView.setLayoutParams(params);
        webDetailView.setInitialScale(100);
        viewBinding.webDetailLlayout.addView(webDetailView);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_web_detail;
    }
}
