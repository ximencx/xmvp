package com.xm.testmvp.di;

import com.xm.testmvp.data.datastore.IMainDataStore;
import com.xm.testmvp.data.datastore.MainCloudDataStore;
import com.xm.xmvp.di.annotation.DiConfig;
import com.xm.xmvp.di.annotation.StoreQua;

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
    @StoreQua(DiConfig.TYPE_CLOUD)
    public abstract IMainDataStore providerMainDataStore(MainCloudDataStore dataStore);

    public interface Provider {

        @StoreQua(DiConfig.TYPE_CLOUD)
        IMainDataStore punchMainDataStore();
    }
}
