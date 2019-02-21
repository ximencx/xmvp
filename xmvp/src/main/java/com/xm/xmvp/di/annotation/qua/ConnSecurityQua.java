package com.xm.xmvp.di.annotation.qua;

import android.support.annotation.NonNull;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
@Documented
@Qualifier
@Retention(RetentionPolicy.CLASS)
public @interface ConnSecurityQua {
    /**
     * 网络连接安全性限定符
     *
     * @return 网络连接安全性限定符
     */
    @NonNull @DiConfig.ConnType String value() default DiConfig.CONN_HTTPS;
}