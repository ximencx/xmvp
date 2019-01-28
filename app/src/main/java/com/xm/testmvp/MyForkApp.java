package com.xm.testmvp;

import android.app.Application;
import android.content.res.Configuration;

import com.xm.testmvp.di.MainActivityComponent;
import com.xm.testmvp.di.MainFragmentComponent;
import com.xm.testmvp.presenter.BaseMainActivity;
import com.xm.testmvp.presenter.BaseMainFragment;
import com.xm.xmvp.application.BoundedApplication;
import com.xm.xmvp.di.module.ActivityModule;

/**
 * created on 2019/1/27.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class MyForkApp implements BoundedApplication {

    public static MainActivityComponent getMainActivityComponent(BaseMainActivity activity) {
//        return MainActivityComponent.
//                .builder()
//                .activityModule(new ActivityModule(activity))
//                .eoaActivityModule(new EoaActivityModule(activity))
//                .punchComponent(punchComponent)
//                .build();
        return null;
    }

    public static MainFragmentComponent getMainFragmentComponent(BaseMainFragment vBaseMainFragment, MainActivityComponent activityComponent) {
//        return DaggerPunchFragmentComponent
//                .builder()
//                .eoaFragmentModule(new EoaFragmentModule(fragment))
//                .fragmentModule(new FragmentModule(fragment))
//                .punchActivityComponent(activityComponent)
//                .build();
        return null;
    }

    @Override
    public void onCreate(Application application) {

    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }

    @Override
    public void onDestroy() {

    }
}
