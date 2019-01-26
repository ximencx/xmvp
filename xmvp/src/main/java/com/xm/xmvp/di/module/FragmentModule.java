package com.xm.xmvp.di.module;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.xm.xmvp.di.base.SmartFragment;
import com.xm.xmvp.di.annotation.AroundQua;
import com.xm.xmvp.di.annotation.DiConfig;
import com.xm.xmvp.di.annotation.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
@Module
public class FragmentModule {

    private final SmartFragment smartFragment;

    public FragmentModule(@NonNull SmartFragment smartFragment) {
        this.smartFragment = smartFragment;
    }

    @PerFragment
    @Provides
    Fragment provideFragment() {
        return this.smartFragment;
    }

    @PerFragment
    @Provides
    @AroundQua(DiConfig.QUA_FRAGMENT)
    Bundle provideBundle() {
        return this.smartFragment.getArguments();
    }

    @PerFragment
    @Provides
    @AroundQua(DiConfig.QUA_FRAGMENT)
    Context provideContext() {
        return this.smartFragment.getContext();
    }

    @PerFragment
    @Provides
    @AroundQua(DiConfig.QUA_FRAGMENT)
    Activity provideActivity() {
        return this.smartFragment.getActivity();
    }

    public interface Provider {
        Fragment fragment();

        @AroundQua(DiConfig.QUA_FRAGMENT)
        Activity activity4Fragment();

        @AroundQua(DiConfig.QUA_FRAGMENT)
        Context fragmentContext();

        @AroundQua(DiConfig.QUA_FRAGMENT)
        Bundle fragmentBundle();
    }

}
