package com.njqg.orchard.library_core.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.njqg.orchard.library_core.utils.CrashUtils;
import com.njqg.orchard.library_core.utils.SPUtils;
import com.njqg.orchard.library_core.utils.Utils;
import com.squareup.leakcanary.LeakCanary;

public class BaseApp extends Application {

    private static BaseApp app;

    public static Context getAppContext() {
        return app;
    }

    public static Resources getAppResources() {
        return app.getResources();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        app=this;
        SPUtils.init(this);
        Utils.init(this);
        CrashUtils.getInstance().init();

    }
}
