package com.hans.wanandroid.utils;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.hans.wanandroid.R;
import com.njqg.orchard.library_core.image.GlideApp;
import com.njqg.orchard.library_core.utils.LogUtils;

/**
 * Created by hans
 * date: 2018/3/5 14:37.
 * e-mail: hxxx1992@163.com
 */

public class Utils {

    @BindingAdapter({"imageUrl"})
    public void loadImage(ImageView imageView, String url) {
        LogUtils.e("url:" + url);
        if (TextUtils.isEmpty(url)) {
            //如果网址为空, 默认加载ic_launcher
            imageView.setImageResource(R.mipmap.wan_android);
        } else {
            //使用Glide加载图片
            GlideApp.with(imageView.getContext()).load(url).into(imageView);
        }
    }

}
