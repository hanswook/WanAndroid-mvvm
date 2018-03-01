package com.hans.wanandroid.net;

import com.hans.wanandroid.utils.Constant;
import com.njqg.orchard.library_core.utils.LogUtils;
import com.njqg.orchard.library_core.utils.SPUtils;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;

/**
 * Created by hans
 * date: 2018/2/27 16:27.
 * e-mail: hxxx1992@163.com
 */

public class ReceivedCookiesInterceptor implements Interceptor {

    private HashSet<String> cookies = new HashSet<>();

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        okhttp3.Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {

            for (String header : originalResponse.headers("Set-Cookie")) {
                LogUtils.e("ReceivedCookiesInterceptor", "header:" + header);
                SPUtils.put(Constant.SP_NAME,header.split("=")[0],header);
                cookies.add(header);
            }
        }
        return originalResponse;
    }
}
