package com.xm.xmvp.di.module;

import dagger.Module;

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

