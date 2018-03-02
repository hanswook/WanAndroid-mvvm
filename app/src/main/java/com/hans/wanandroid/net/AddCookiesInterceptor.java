package com.hans.wanandroid.net;

import android.util.Log;

import com.hans.wanandroid.utils.Constant;
import com.njqg.orchard.library_core.utils.LogUtils;
import com.njqg.orchard.library_core.utils.SPUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * Created by hans
 * date: 2018/2/27 16:35.
 * e-mail: hxxx1992@163.com
 */

public class AddCookiesInterceptor implements Interceptor {

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        List<String> cookies = new ArrayList<>();
        String a = SPUtils.getString(Constant.SP_NAME, Constant.LOGIN_USER_NAME_COOKIE);
        cookies.add(a);
        String b = SPUtils.getString(Constant.SP_NAME, Constant.LOGIN_USER_PASSWORD_COOKIE);
        cookies.add(b);

        for (String cookie : cookies) {
            if (cookie != null && !cookie.equalsIgnoreCase("")) {
                builder.addHeader("Cookie", cookie);
                LogUtils.e("OkHttp", "Adding Header: " + cookie); // This is done so I know which headers are being added; this interceptor is used after the normal logging of OkHttp
            }
        }

        return chain.proceed(builder.build());
    }
}
