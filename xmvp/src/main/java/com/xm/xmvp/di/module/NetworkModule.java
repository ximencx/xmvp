package com.xm.xmvp.di.module;

import android.content.Context;
import android.support.annotation.NonNull;

import com.squareup.okhttp.OkHttpClient;
import com.xm.xmvp.di.annotation.AroundQua;
import com.xm.xmvp.di.annotation.ConnSecurityQua;
import com.xm.xmvp.di.annotation.DiConfig;

import javax.inject.Inject;
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
public class NetworkModule {

    private boolean isLog = true;

    public NetworkModule() {

    }

    public NetworkModule(boolean isLog) {
        this.isLog = isLog;
    }

//    @Singleton
//    @Provides
//    @ConnSecurityQua(DiConfig.CONN_HTTP)
//    OkHttpClient.Builder provideOkHttpClientBuilder() {
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
////        if (this.isLog) {
////            builder.addInterceptor(getHttpLoggingInterceptor());
////        }
//        return builder;
//    }

    public interface Provider{

//        @ConnSecurityQua(DiConfig.CONN_HTTP)
//        OkHttpClient.Builder okHttpClient();
//
//        @ConnSecurityQua(DiConfig.CONN_HTTPS)
//        OkHttpClient.Builder okHttpsClient();
    }
}

