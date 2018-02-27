package com.njqg.orchard.library_core.base;


import io.reactivex.disposables.Disposable;

/**
 * Created by hans
 * date: 2017/11/23 17:22.
 * e-mail: hxxx1992@163.com
 */

public interface BaseImpl {
    /**
     * 显示ProgressDialog
     */
    void showProgress();

    /**
     * 显示ProgressDialog
     *
     */
    void showProgress(String msg);

    /**
     * 取消ProgressDialog
     */
    void dismissProgress();



    boolean addRxStop(Disposable disposable);

    boolean addRxDestroy(Disposable disposable);

    void remove(Disposable disposable);


}
