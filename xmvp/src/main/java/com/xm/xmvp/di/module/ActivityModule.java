package com.xm.xmvp.di.module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.xm.xmvp.di.annotation.qua.AroundQua;
import com.xm.xmvp.di.annotation.qua.DiConfig;
import com.xm.xmvp.di.annotation.scope.PerActivity;
import com.xm.xmvp.di.base.BaseMvpDiActivity;

import dagger.Module;
import dagger.Provides;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
@Module
public class ActivityModule {

    private final BaseMvpDiActivity baseMvpDiActivity;

    public ActivityModule(@NonNull BaseMvpDiActivity baseMvpDiActivity) {
        this.baseMvpDiActivity = baseMvpDiActivity;
    }

    @Provides
    @PerActivity
    @AroundQua(DiConfig.QUA_ACTIVITY)
    Activity provideActivity() {
        return this.baseMvpDiActivity;
    }

    @Provides
    @PerActivity
    @AroundQua(DiConfig.QUA_ACTIVITY)
    Context provideContext() {
        return this.baseMvpDiActivity;
    }

    @PerActivity
    @Provides
    Intent provideIntent() {
        return this.baseMvpDiActivity.getIntent();
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
