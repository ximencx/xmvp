package com.xm.xmvp.di.module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.xm.xmvp.di.base.SmartActivity;
import com.xm.xmvp.di.annotation.AroundQua;
import com.xm.xmvp.di.annotation.DiConfig;
import com.xm.xmvp.di.annotation.PerActivity;
import com.xm.xmvp.di.components.FragmentComponent;

import dagger.Module;
import dagger.Provides;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
@Module(subcomponents = FragmentComponent.class)
public class ActivityModule {

    private final SmartActivity smartActivity;

    public ActivityModule(@NonNull SmartActivity smartActivity) {
        this.smartActivity = smartActivity;
    }

    @Provides
    @PerActivity
    @AroundQua(DiConfig.QUA_ACTIVITY)
    Activity provideActivity() {
        return this.smartActivity;
    }

    @Provides
    @PerActivity
    @AroundQua(DiConfig.QUA_ACTIVITY)
    Context provideContext() {
        return this.smartActivity;
    }

    @PerActivity
    @Provides
    Intent provideIntent() {
        return this.smartActivity.getIntent();
    }

    @Provides
    @PerActivity
    @AroundQua(DiConfig.QUA_ACTIVITY)
    @Nullable
    Bundle provideBundle(Intent intent) {
        return intent.getExtras();
    }

    public interface Provider {

        @AroundQua(DiConfig.QUA_ACTIVITY)
        Activity activity();

        @AroundQua(DiConfig.QUA_ACTIVITY)
        Context activityContext();

        Intent intent();

        @Nullable
        @AroundQua(DiConfig.QUA_ACTIVITY)
        Bundle activityBundle();
    }
}
