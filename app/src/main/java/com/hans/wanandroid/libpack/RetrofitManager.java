package com.hans.wanandroid.libpack;

import com.hans.wanandroid.net.AddCookiesInterceptor;
import com.hans.wanandroid.net.ReceivedCookiesInterceptor;
import com.hans.wanandroid.utils.Constant;
import com.njqg.orchard.library_core.utils.LibConstant;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hans
 * date: 2017/11/23 17:17.
 * e-mail: hxxx1992@163.com
 * wiki： RetrofitManager.getInstance().create(***.class).
 *
 * 复制此类到新建APP项目内，自定义baseurl以及构造中需要的参数，
 *
 */

public class RetrofitManager {
    private static RetrofitManager sInstace;
    private static OkHttpClient client;
    private static Retrofit retrofit;

    /**
     * 私有构造方法
     */
    private RetrofitManager() {
        //设置 请求的缓存的大小跟位置
        File cacheFile = new File(Constant.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50); //50Mb 缓存的大小
        client = new OkHttpClient
                .Builder()
                .addInterceptor(new AddCookiesInterceptor())  //cookies添加
                .addInterceptor(new ReceivedCookiesInterceptor()) // cookies获取
                .addInterceptor(new HttpLoggingInterceptor()) //日志,所有的请求响应度看到
//                .cache(cache)  //添加缓存
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)

                .build();
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .client(client)
                .build();
    }



    /**
     * 创建单例
     */
    public static RetrofitManager getInstance() {
        if (sInstace == null) {
            synchronized (RetrofitManager.class) {
                sInstace = new RetrofitManager();
            }
        }
        return sInstace;
    }


    public Retrofit getRetrofit() {
        return retrofit;
    }


    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }



}
