package com.xm.xmvp.application;

import android.app.Application;
import android.content.res.Configuration;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class BaseBoundedApplication implements BoundedApplication {

    @Override
    public void onCreate(Application application) {

    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }

    @Override
    public void onDestroy() {

    }
}

