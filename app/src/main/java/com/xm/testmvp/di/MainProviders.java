package com.xm.testmvp.di;

import com.xm.xmvp.di.components.Providers;
import com.xm.xmvp.di.module.ActivityModule;
import com.xm.xmvp.di.module.FragmentModule;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public interface MainProviders {

    interface MainComponentProvider extends Providers.ApplicationComponentProvider, MainModule.Provider, StoreModule.Provider {
    }

    interface MainActivityComponentProvider extends MainComponentProvider, ActivityModule.Provider {
    }

    interface MainFragmentComponentProvider extends MainActivityComponentProvider, FragmentModule.Provider {
    }
}