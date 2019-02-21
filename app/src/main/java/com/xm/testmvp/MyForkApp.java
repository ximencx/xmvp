package com.xm.testmvp;

import android.app.Application;
import android.content.res.Configuration;

import com.xm.testmvp.di.DaggerMainActivityComponent;
import com.xm.testmvp.di.DaggerMainComponent;
import com.xm.testmvp.di.DaggerMainFragmentComponent;
import com.xm.testmvp.di.MainActivityComponent;
import com.xm.testmvp.di.MainComponent;
import com.xm.testmvp.di.MainFragmentComponent;
import com.xm.testmvp.presenter.BaseMainActivity;
import com.xm.testmvp.presenter.BaseMainFragment;
import com.xm.xmvp.application.BoundedApplication;
import com.xm.xmvp.di.module.ActivityModule;
import com.xm.xmvp.di.module.FragmentModule;

/**
 * created on 2019/1/27.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class MyForkApp implements BoundedApplication {

    private static MainComponent mainComponent;

    public static MainComponent getMainComponent(Application application) {
        return DaggerMainComponent.builder()
                .applicationComponent(((MyApp) application).getApplicationComponent())
                .build();
    }

    public static MainActivityComponent getMainActivityComponent(BaseMainActivity activity) {
        return DaggerMainActivityComponent
                .builder()
                .activityModule(new ActivityModule(activity))
                .mainComponent(mainComponent)
                .build();
    }

    public static MainFragmentComponent getMainFragmentComponent(BaseMainFragment fragment, MainActivityComponent activityComponent) {
        return DaggerMainFragmentComponent
                .builder()
                .fragmentModule(new FragmentModule(fragment))
                .mainActivityComponent(activityComponent)
                .build();
    }

    @Override
    public void onCreate(Application application) {
        mainComponent = getMainComponent(application);
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
