package com.xm.xmvp.di.annotation.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
@Documented
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface PerApplication {}