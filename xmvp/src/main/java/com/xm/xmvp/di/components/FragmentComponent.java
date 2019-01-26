package com.xm.xmvp.di.components;

import com.xm.xmvp.di.annotation.PerFragment;
import com.xm.xmvp.di.module.FragmentModule;

import dagger.Subcomponent;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
@PerFragment
@Subcomponent(modules = {FragmentModule.class})
public interface FragmentComponent extends Providers.FragmentComponentProvider {

    @Subcomponent.Builder
    interface Builder {
        FragmentComponent build();

        FragmentComponent.Builder fragmentModule(FragmentModule fragmentModule);
    }
}
