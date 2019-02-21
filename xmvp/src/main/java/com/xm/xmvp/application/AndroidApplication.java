package com.xm.xmvp.application;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.xm.xmvp.di.base.BaseMvpDiActivity;
import com.xm.xmvpbase.ActivityStack;
import com.xm.xmvp.BuildConfig;
import com.xm.xmvp.di.base.BaseMvpDiFragment;
import com.xm.xmvp.di.components.ActivityComponent;
import com.xm.xmvp.di.components.ApplicationComponent;
import com.xm.xmvp.di.components.DaggerApplicationComponent;
import com.xm.xmvp.di.components.FragmentComponent;
import com.xm.xmvp.di.module.ActivityModule;
import com.xm.xmvp.di.module.ApplicationModule;
import com.xm.xmvp.di.module.EventModule;
import com.xm.xmvp.di.module.ExecutorModule;
import com.xm.xmvp.di.module.FragmentModule;
import com.xm.xmvp.di.module.NetworkModule;
import com.xm.xmvp.di.module.UtilModule;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public abstract class AndroidApplication extends ForkedApplication{

    public static final String COMTAG_APPLICATION_COMPONENT = "applicationComponent";

    /**
     * Gets application component.
     *
     * @return the application component
     */
    public ApplicationComponent getApplicationComponent() {
        ApplicationComponent applicationComponent = getComponent(COMTAG_APPLICATION_COMPONENT);
        if (applicationComponent == null) {
            applicationComponent = createApplicationComponent();
            registComponent(COMTAG_APPLICATION_COMPONENT, applicationComponent);
        }
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        Utils.init(this);
        this.registerActivityLifecycleCallbacks(
                new ActivityLifecycleCallbacks() {

                    @Override
                    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                        ActivityStack.getInstance().pushActivity(activity);
                    }

                    @Override
                    public void onActivityStarted(Activity activity) {

                    }

                    @Override
                    public void onActivityResumed(Activity activity) {

                    }

                    @Override
                    public void onActivityPaused(Activity activity) {

                    }

                    @Override
                    public void onActivityStopped(Activity activity) {

                    }

                    @Override
                    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

                    }

                    @Override public void onActivityDestroyed(Activity activity) {
                        ActivityStack.getInstance().popActivity(activity, false);
                    }
                }
        );
        super.onCreate();
    }

    private ApplicationComponent createApplicationComponent() {
        return DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .utilModule(new UtilModule())
                .networkModule(new NetworkModule(BuildConfig.DEBUG))
                .executorModule(new ExecutorModule())
                .eventModule(new EventModule())
                .build();
    }

    /**
     * Create activity component activity component.
     *
     * @param activity the activity
     * @return the activity component
     */
    public ActivityComponent createActivityComponent(@NonNull BaseMvpDiActivity activity) {
        return this.getApplicationComponent()
                .activityComponentBuilder()
                .activityModule(new ActivityModule(activity))
                .build();
    }

    /**
     * Create fragment component fragment component.
     *
     * @param fragment          the fragment
     * @param activityComponent the activity component
     * @return the fragment component
     */
    public FragmentComponent createFragmentComponent(@NonNull BaseMvpDiFragment fragment,
                                                     @NonNull ActivityComponent activityComponent) {
        return activityComponent.fragmentComponentBuilder()
                .fragmentModule(new FragmentModule(fragment))
                .build();
    }
}

