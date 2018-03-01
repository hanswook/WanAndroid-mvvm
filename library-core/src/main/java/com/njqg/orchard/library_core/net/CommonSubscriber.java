package com.njqg.orchard.library_core.net;


import android.content.Context;
import android.widget.Toast;


import com.njqg.orchard.library_core.base.BaseLibActivity;
import com.njqg.orchard.library_core.utils.LogUtils;
import com.njqg.orchard.library_core.utils.NetWorkUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * Created by hans
 * date: 2017/11/23 17:17.
 * e-mail: hxxx1992@163.com
 */
public abstract class CommonSubscriber<T> implements Observer<T> {
    private Context context;

    protected CommonSubscriber(Context context) {
        this.context = context;
    }

    private static final String TAG = "CommonSubscriber";

    @Override
    public void onSubscribe(Disposable d) {
        if (!NetWorkUtils.isConnectedByState(context)) {
            LogUtils.e(TAG, "网络不可用");
            Toast.makeText(context, "网络存在问题，请检查后重新运行", Toast.LENGTH_SHORT).show();
        } else {
            LogUtils.i(TAG, "网络可用");
        }
        if (context instanceof BaseLibActivity) {
            ((BaseLibActivity) context).addRxDestroy(d);

        }

    }

    @Override
    public void onError(Throwable e) {
        LogUtils.e(TAG, "e:" + e.toString());
    }

    @Override
    public void onComplete() {
//        LogUtil.e(TAG, "成功了");
    }
}
