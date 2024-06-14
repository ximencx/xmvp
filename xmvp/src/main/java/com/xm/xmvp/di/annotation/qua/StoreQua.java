package com.xm.xmvp.di.annotation.qua;


import androidx.annotation.NonNull;

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
public @interface StoreQua {
    /**
     * 数据源类型限定符
     *
     * @return 数据源类型限定符
     */
    @NonNull @DiConfig.StoreType String value() default DiConfig.TYPE_DISK;
}