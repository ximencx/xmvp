package com.xm.xmvp.di.module;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.xm.xmvp.di.annotation.qua.AroundQua;
import com.xm.xmvp.di.annotation.qua.DiConfig;
import com.xm.xmvp.di.annotation.scope.PerFragment;
import com.xm.xmvp.di.base.BaseMvpDiFragment;

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

    private final BaseMvpDiFragment baseMvpDiFragment;

    public FragmentModule(@NonNull BaseMvpDiFragment baseMvpDiFragment) {
        this.baseMvpDiFragment = baseMvpDiFragment;
    }

    @PerFragment
    @Provides
    Fragment provideFragment() {
        return this.baseMvpDiFragment;
    }

    @PerFragment
    @Provides
    @AroundQua(DiConfig.QUA_FRAGMENT)
    Bundle provideBundle() {
        return this.baseMvpDiFragment.getArguments();
    }

    @PerFragment
    @Provides
    @AroundQua(DiConfig.QUA_FRAGMENT)
    Context provideContext() {
        return this.baseMvpDiFragment.getContext();
    }

    @PerFragment
    @Provides
    @AroundQua(DiConfig.QUA_FRAGMENT)
    Activity provideActivity() {
        return this.baseMvpDiFragment.getActivity();
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
