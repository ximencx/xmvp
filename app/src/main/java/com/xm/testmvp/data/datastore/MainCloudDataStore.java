package com.xm.testmvp.data.datastore;

import javax.inject.Inject;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class MainCloudDataStore implements IMainDataStore {

    @Inject
    public MainCloudDataStore() {
    }

    @Override
    public String getString() {
        return "this is test";
    }
}
