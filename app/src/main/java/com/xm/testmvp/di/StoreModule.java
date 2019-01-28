package com.xm.testmvp.di;

import com.xm.testmvp.data.datastore.IMainDataStore;
import com.xm.testmvp.data.datastore.MainCloudDataStore;

import dagger.Binds;
import dagger.Module;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
@Module
public abstract class StoreModule {

    @Binds
    @PerMain
    public abstract IMainDataStore providerMainDataStore(MainCloudDataStore dataStore);

    public interface Provider {

        IMainDataStore punchMainDataStore();
    }
}
