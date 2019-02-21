package com.xm.testmvp.data.repository;

import com.xm.testmvp.data.datastore.IMainDataStore;
import com.xm.xmvp.di.annotation.qua.DiConfig;
import com.xm.xmvp.di.annotation.qua.StoreQua;

import javax.inject.Inject;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class ImplMainRepository implements IMainRepository {

    private IMainDataStore dataStore;

    @Inject
    ImplMainRepository(@StoreQua(DiConfig.TYPE_CLOUD) IMainDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public String getString() {
        return dataStore.getString();
    }
}
