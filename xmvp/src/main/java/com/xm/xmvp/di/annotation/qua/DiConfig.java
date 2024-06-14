package com.xm.xmvp.di.annotation.qua;



import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class DiConfig {

    @Retention(RetentionPolicy.CLASS)
    @StringDef({QUA_APPLICATION, QUA_ACTIVITY, QUA_FRAGMENT})
    public @interface QuaType {
    }

    public static final String QUA_APPLICATION = "qua_application";
    public static final String QUA_ACTIVITY = "qua_activity";
    public static final String QUA_FRAGMENT = "qua_fragment";


    @Retention(RetentionPolicy.CLASS)
    @StringDef(value = {CONN_HTTP, CONN_HTTPS, CONN_HTTP_V0,
            CONN_HTTPS_V0, CONN_HTTP_V1, CONN_HTTPS_V1})
    public @interface ConnType {
    }

    /**
     * http链接
     */
    public static final String CONN_HTTP = "http";
    /**
     * https链接
     */
    public static final String CONN_HTTPS = "https";

    /**
     * http链接版本1
     */
    public static final String CONN_HTTP_V0 = "httpV0";
    /**
     * https链接版本1
     */
    public static final String CONN_HTTPS_V0 = "httpsV0";
    /**
     * http链接版本2
     */
    public static final String CONN_HTTP_V1 = "httpV1";
    /**
     * https链接版本2
     */
    public static final String CONN_HTTPS_V1 = "httpsV1";


    @Retention(RetentionPolicy.CLASS)
    @StringDef(value = {TYPE_CLOUD, TYPE_DISK, TYPE_MEMORY, TYPE_DEFAULT})
    public @interface StoreType {
    }

    /**
     * 数据源--硬盘数据源
     */
    public static final String TYPE_DISK = "disk";
    /**
     * 数据源--网络数据源
     */
    public static final String TYPE_CLOUD = "cloud";
    /**
     * 数据源--内存数据源
     */
    public static final String TYPE_MEMORY = "memory";
    /**
     * 数据源--默认数据源
     */
    public static final String TYPE_DEFAULT = "default";
}

