package com.hans.wanandroid.libpack;


import com.njqg.orchard.library_core.base.BaseApp;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by hans
 * date: 2017/11/28 16:37.
 * e-mail: hxxx1992@163.com
 */

public class WanAndroidApp extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "333970e771", false);
        DataBaseHelper.getInstance().setDatabase();
    }
}
