package com.hans.wanandroid.libpack;

import android.databinding.DataBindingComponent;

import com.hans.wanandroid.utils.Utils;

/**
 * Created by hans
 * date: 2018/3/5 15:08.
 * e-mail: hxxx1992@163.com
 */

public class WanComponent implements DataBindingComponent {
    private Utils utils;

    @Override
    public Utils getUtils() {
        if (null == utils) {
            utils = new Utils();
        }
        return utils;
    }
}
