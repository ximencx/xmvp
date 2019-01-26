package com.xm.xmvp.di.module.util;

import android.support.annotation.NonNull;

import rx.Scheduler;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public interface PostExecutionThread {
    @NonNull
    Scheduler getScheduler();
}