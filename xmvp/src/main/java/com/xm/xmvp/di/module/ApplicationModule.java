package com.xm.xmvp.di.module;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

import com.xm.xmvp.application.AndroidApplication;
import com.xm.xmvp.di.annotation.AroundQua;
import com.xm.xmvp.di.annotation.DiConfig;
import com.xm.xmvp.di.components.ActivityComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
@Module(subcomponents = {ActivityComponent.class})
public class ApplicationModule {

    private final AndroidApplication application;

    public ApplicationModule(@NonNull AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @AroundQua(DiConfig.QUA_APPLICATION)
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(this.application);
    }

    @Singleton
    @Provides
    ActivityManager provideActivityManager() {
        return ((ActivityManager) this.application.getSystemService(Context.ACTIVITY_SERVICE));
    }

    @Singleton
    @Provides
    AlarmManager provideAlarmManager() {
        return ((AlarmManager) this.application.getSystemService(Context.ALARM_SERVICE));
    }

    @Singleton
    @Provides
    NotificationManager provideNotificationManager() {
        return ((NotificationManager) this.application.getSystemService(Context.NOTIFICATION_SERVICE));
    }

    public interface Provider{
        @AroundQua(DiConfig.QUA_APPLICATION)
        Context applicationContext();

        LayoutInflater layoutInflater();

        ActivityManager activityManager();

        AlarmManager alarmManager();

        NotificationManager notificationmanager();
    }
}

