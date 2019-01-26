package com.xm.testmvp.di;

import com.xm.xmvp.di.components.ApplicationComponent;

import dagger.Component;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
@PerMain
@Component(modules = {MainModule.class, StoreModule.class},
        dependencies = ApplicationComponent.class)
public interface MainComponent {

}
