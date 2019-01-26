package com.xm.xmvp.di.module.impl;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class UIThreadImpl implements PostExecutionThread {

    @Inject
    public UIThreadImpl() {}

    @NonNull
    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}