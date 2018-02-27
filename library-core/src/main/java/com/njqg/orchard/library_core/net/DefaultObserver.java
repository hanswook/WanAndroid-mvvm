package com.njqg.orchard.library_core.net;


import com.google.gson.JsonParseException;
import com.njqg.orchard.library_core.base.BaseImpl;
import com.njqg.orchard.library_core.utils.LogUtils;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

import static com.njqg.orchard.library_core.net.HttpExceptions.ExceptionReason.BAD_NETWORK;
import static com.njqg.orchard.library_core.net.HttpExceptions.ExceptionReason.CONNECT_ERROR;
import static com.njqg.orchard.library_core.net.HttpExceptions.ExceptionReason.CONNECT_TIMEOUT;
import static com.njqg.orchard.library_core.net.HttpExceptions.ExceptionReason.PARSE_ERROR;
import static com.njqg.orchard.library_core.net.HttpExceptions.ExceptionReason.UNKNOWN_ERROR;
import static com.njqg.orchard.library_core.net.HttpExceptions.onException;


/**
 * Created by hans on 2017/4/18.
 * 有dialog 的 observer;
 */

public abstract class DefaultObserver<T> implements Observer<T> {
    private BaseImpl mBaseImpl;
    //  Activity 是否在执行onStop()时取消订阅
    private boolean isAddInStop = false;

    public DefaultObserver(BaseImpl baseImpl) {
        mBaseImpl = baseImpl;
        mBaseImpl.showProgress();
    }

    public DefaultObserver(BaseImpl baseImpl, boolean isShowLoading) {
        mBaseImpl = baseImpl;
        if (isShowLoading) {
            mBaseImpl.showProgress();
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (isAddInStop) {    //  在onStop中取消订阅
            mBaseImpl.addRxStop(d);
        } else { //  在onDestroy中取消订阅
            LogUtils.e(mBaseImpl.getClass().getSimpleName(),"gankb:add destory");
            mBaseImpl.addRxDestroy(d);
        }
    }

    @Override
    public void onNext(T t) {
        mBaseImpl.dismissProgress();
        doOnNext(t);
    }

    protected abstract void doOnNext(T t);

    @Override
    public void onError(Throwable e) {
        LogUtils.e("Retrofit", e.getMessage());
        mBaseImpl.dismissProgress();
        if (e instanceof HttpException) {     //   HTTP错误
            onException(BAD_NETWORK);
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException) {   //   连接错误
            onException(CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {   //  连接超时
            onException(CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {   //  解析错误
            onException(PARSE_ERROR);
        } else {
            onException(UNKNOWN_ERROR);
        }
    }

    @Override
    public void onComplete() {
    }


}
