package com.xm.xmvp.di.module;

import com.xm.xmvp.di.module.impl.BusProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
@Module
public class EventModule {
    @Singleton
    @Provides
    BusProvider providerEventBus() {
        return new BusProvider();
    }

    public interface Provider {
        BusProvider busProvider();
    }
}
