package com.xm.xmvp.application;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public abstract class ForkedApplication extends ComponentApplication {

    public static final String LC_ONCREATE = "onCreate";
    public static final String LC_ONTERMINATE = "onTerminate";
    public static final String LC_ONCONFIGURATIONCHANGED = "onConfigurationChanged";
    public static final String LC_ONLOWMEMORY = "onLowMemory";
    public static final String LC_ONTRIMMEMORY = "onTrimMemory";
    public static final String LC_ONDESTROY = "onDestroy";

    private LinkedHashMap<String, BoundedApplication> boundedApplications;

    /**
     * 构建BoundedApp图表
     *
     * @return BoundedApp图表
     */
    @Nullable
    public abstract List<BoundedAppProvider> buildBoundedAppGraph();

    /**
     * 模拟Application"onCreate"生命周期调用完成之后
     */
    public abstract void afterForkedApplicationsBounded();

    /**
     * 模拟Application"onCreate"生命周期调用开始之前
     */
    public abstract void preForkedApplicationsBounded();


    @Override
    public void onCreate() {
        super.onCreate();
        preForkedApplicationsBounded();
        //初始化模块接口和Application生命周期对象
        initForkedApplications();
        //初始化
        afterForkedApplicationsBounded();
        //开始Application生命周期
        performLifeCycle(LC_ONCREATE, null);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        performLifeCycle(LC_ONTERMINATE, null);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        performLifeCycle(LC_ONCONFIGURATIONCHANGED, newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        performLifeCycle(LC_ONLOWMEMORY, null);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        performLifeCycle(LC_ONTRIMMEMORY, level);
    }

    /**
     * 根据类型获取已经存在的模拟Application
     *
     * @param tag 模拟Application的标签
     * @param <T> 模拟Application类型定义
     * @return 模拟Application对象
     */
    @SuppressWarnings("unchecked") @Nullable
    public <T extends BoundedApplication> T getForkedApplication(@NonNull String tag) {
        if (boundedApplications != null && !boundedApplications.isEmpty()) {
            return ((T) boundedApplications.get(tag));
        }
        return null;
    }

    private void initForkedApplications() {
        List<BoundedApplicationConfig> configs = null;
        List<BoundedAppProvider> boundedAppProviders = buildBoundedAppGraph();
        if (boundedAppProviders != null && !boundedAppProviders.isEmpty()) {
            configs = new ArrayList<>();
            for (BoundedAppProvider provider : boundedAppProviders) {
                if (provider != null && provider.provideBoundedApplications() != null) {
                    configs.addAll(provider.provideBoundedApplications());
                }
            }
        }

        if (configs != null && !configs.isEmpty()) {
            Collections.sort(configs);
            this.boundedApplications = new LinkedHashMap<>();
            for (BoundedApplicationConfig config : configs) {
                if (config != null) {
                    String tag = config.getTag();
                    BoundedApplication boundedApplication = config.getBoundedApplication();
                    if (TextUtils.isEmpty(tag) || boundedApplication == null) {
                        throw new RuntimeException("BoundedApplicationConfig not valid,please check");
                    }
                    this.boundedApplications.put(tag, boundedApplication);
                }
            }
        }
    }


    @SuppressWarnings("ConstantConditions")
    public void performLifeCycle(String lc, @Nullable Object arg) {

        if (this.boundedApplications == null || this.boundedApplications.isEmpty()) return;

        Set<Map.Entry<String, BoundedApplication>> entries = this.boundedApplications.entrySet();
        for (Map.Entry<String, BoundedApplication> entry : entries) {

            if (entry == null || entry.getValue() == null) continue;

            BoundedApplication boundedApplication = entry.getValue();
            switch (lc) {
                case LC_ONCREATE:
                    boundedApplication.onCreate(this);
                    break;
                case LC_ONTERMINATE:
                    boundedApplication.onTerminate();
                    break;
                case LC_ONCONFIGURATIONCHANGED:
                    if (arg != null)
                        boundedApplication.onConfigurationChanged(((Configuration) arg));
                    break;
                case LC_ONLOWMEMORY:
                    boundedApplication.onLowMemory();
                    break;
                case LC_ONTRIMMEMORY:
                    if (arg != null)
                        boundedApplication.onTrimMemory(((Integer) arg));
                    break;
                case LC_ONDESTROY:
                    boundedApplication.onDestroy();
                    break;
                default:
                    break;
            }
        }
    }

    @Nullable
    public static <T extends BoundedApplication> T getForkedApplication(@NonNull Context context, @NonNull String appTag) {
        Context applicationContext = context.getApplicationContext();

        if (applicationContext instanceof ForkedApplication) {
            ForkedApplication forkedApplication = (ForkedApplication) applicationContext;
            return forkedApplication.getForkedApplication(appTag);
        }

        return null;
    }
}

