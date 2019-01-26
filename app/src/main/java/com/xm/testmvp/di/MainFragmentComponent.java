package com.xm.testmvp.di;

import com.xm.xmvp.di.annotation.PerFragment;
import com.xm.xmvp.di.module.FragmentModule;

import dagger.Component;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
@PerFragment
@Component(modules = {FragmentModule.class, FragmentModule.class},
        dependencies = MainActivityComponent.class)
public interface MainFragmentComponent extends MainProviders.MainFragmentComponentProvider {


}