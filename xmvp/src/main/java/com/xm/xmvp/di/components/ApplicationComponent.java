package com.xm.xmvp.di.components;

import com.xm.xmvp.di.module.ApplicationModule;
import com.xm.xmvp.di.module.EventModule;
import com.xm.xmvp.di.module.ExecutorModule;
import com.xm.xmvp.di.module.NetworkModule;
import com.xm.xmvp.di.module.UtilModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                EventModule.class,
                ExecutorModule.class,
                NetworkModule.class,
                UtilModule.class
        }
)
public interface ApplicationComponent extends Providers.ApplicationComponentProvider{
    ActivityComponent.Builder activityComponentBuilder();
}