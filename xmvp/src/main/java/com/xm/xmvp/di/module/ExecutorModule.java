package com.xm.xmvp.di.module;

import com.xm.xmvp.di.module.impl.PostExecutionThread;
import com.xm.xmvp.di.module.impl.ThreadExecutor;
import com.xm.xmvp.di.module.impl.ThreadExecutorImpl;
import com.xm.xmvp.di.module.impl.UIThreadImpl;

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
public class ExecutorModule {

    @Singleton
    @Provides
    PostExecutionThread providePostExecutionThread(UIThreadImpl impl) {
        return impl;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(ThreadExecutorImpl impl) {
        return impl;
    }

    public interface Provider {
        ThreadExecutor threadExecutor();

        PostExecutionThread postExecutionThread();
    }
}
