package com.xm.testmvp.di;

import com.xm.testmvp.data.repository.IMainRepository;
import com.xm.testmvp.data.repository.ImplMainRepository;

import dagger.Binds;
import dagger.Module;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
@Module
public abstract class MainModule {

    @Binds
    @PerMain
    public abstract IMainRepository provideMainRepository(ImplMainRepository repository);

    public interface Provider {

        IMainRepository mainRepository();
    }
}
