package com.xm.testmvp.di;

import com.xm.testmvp.main.MainActivity;
import com.xm.xmvp.di.annotation.scope.PerActivity;
import com.xm.xmvp.di.module.ActivityModule;

import dagger.Component;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
@PerActivity
@Component(modules = {ActivityModule.class},
        dependencies = MainComponent.class)
public interface MainActivityComponent extends MainProviders.MainActivityComponentProvider {

    void inject(MainActivity mainActivity);
}