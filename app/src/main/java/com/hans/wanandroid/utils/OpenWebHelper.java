package com.hans.wanandroid.utils;

import android.content.Context;
import android.content.Intent;

import com.hans.wanandroid.view.activity.WebDetailActivity;

/**
 * Created by hans
 * date: 2018/3/1 09:38.
 * e-mail: hxxx1992@163.com
 */

public class OpenWebHelper {

    public static void openWeb(Context context, String url) {
        if (null == url || url.equalsIgnoreCase("")) {
            return;
        }
        Intent intent = new Intent(context, WebDetailActivity.class);
        intent.putExtra(Constant.WEB_DETAIL_URL, url);
        context.startActivity(intent);
    }
}
