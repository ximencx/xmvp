package com.xm.xmvp.di.components;

import com.xm.xmvp.di.annotation.PerActivity;
import com.xm.xmvp.di.module.ActivityModule;

import dagger.Subcomponent;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
@PerActivity
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent extends Providers.ActivityComponentProvider{

    FragmentComponent.Builder fragmentComponentBuilder();

    @Subcomponent.Builder
    interface Builder {
        ActivityComponent build();

        ActivityComponent.Builder activityModule(ActivityModule activityModule);
    }
}
