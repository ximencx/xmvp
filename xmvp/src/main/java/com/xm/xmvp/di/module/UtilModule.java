package com.xm.xmvp.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.xm.xmvp.di.annotation.AroundQua;
import com.xm.xmvp.di.annotation.DiConfig;

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
public class UtilModule {

    @Singleton
    @Provides
    Gson provideGson() {
        return new Gson();
    }

    public interface Provider{
        Gson gson();
    }
}