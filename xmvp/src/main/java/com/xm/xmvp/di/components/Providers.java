package com.xm.xmvp.di.components;

import com.xm.xmvp.di.module.ActivityModule;
import com.xm.xmvp.di.module.ApplicationModule;
import com.xm.xmvp.di.module.EventModule;
import com.xm.xmvp.di.module.ExecutorModule;
import com.xm.xmvp.di.module.FragmentModule;
import com.xm.xmvp.di.module.NetworkModule;
import com.xm.xmvp.di.module.UtilModule;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public interface Providers {
    interface ApplicationComponentProvider extends
            ApplicationModule.Provider,
            EventModule.Provider,
            ExecutorModule.Provider,
            NetworkModule.Provider,
            UtilModule.Provider {}

    interface ActivityComponentProvider extends ActivityModule.Provider,ApplicationComponentProvider{}

    interface FragmentComponentProvider extends FragmentModule.Provider,ActivityComponentProvider{}
}

