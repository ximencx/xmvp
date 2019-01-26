package com.xm.xmvp.di.annotation;

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
public @interface AroundQua {
    /**
     * 全局通用限定符
     *
     * @return 全局通用限定符
     */
    @NonNull @DiConfig.QuaType String value() default DiConfig.QUA_ACTIVITY;
}
