package com.xm.xmvp.di.module;

import com.xm.xmvp.di.module.util.PostExecutionThread;
import com.xm.xmvp.di.module.util.ThreadExecutor;
import com.xm.xmvp.di.module.util.ThreadExecutorImpl;
import com.xm.xmvp.di.module.util.UIThreadImpl;

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

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(ThreadExecutorImpl impl) {
        return impl;
    }

    @Singleton
    @Provides
    PostExecutionThread providePostExecutionThread(UIThreadImpl impl) {
        return impl;
    }

    public interface Provider{
        ThreadExecutor threadExecutor();

        PostExecutionThread postExecutionThread();
    }
}
