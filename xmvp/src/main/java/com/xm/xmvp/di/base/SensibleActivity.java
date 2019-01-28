package com.xm.xmvp.di.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xm.xmvp.presenter.Presenter;
import com.xm.xmvp.vu.Vu;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:支持mvp+dagger2
 */
public abstract class SensibleActivity<V extends Vu.ActivityVu> extends SmartActivity implements Presenter{

    private V vu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preMvpBinding(savedInstanceState);

        Presenter presenter = getPresenter();

        Vu.ActivityVu[] views = getActivityVus();

        if (presenter != null) {
            if (views != null) {
                for (Vu.ActivityVu view : views) {
                    presenter.bindVu(view);
                }
            }
        }

        if (views != null) {
            for (Vu.ActivityVu view : views) {
                if (view != null) {
                    view.bindPresenter(presenter);
                    //设置和View关联的Activity
                    view.bindActivity(this);
                    view.initView(savedInstanceState);
                }
            }
        }

        afterMvpBinding(savedInstanceState);
    }

    private Vu.ActivityVu[] getActivityVus() {
        Vu.ActivityVu views[] = null;
        if (views == null) {
            views = provideVus();
        }
        return views;
    }

    private Presenter getPresenter() {
        Presenter presenter = null;
        if (presenter == null) {
            presenter = providePresenter();
        }
        return presenter;
    }

    public Vu.ActivityVu[] provideVus() {
        Vu.ActivityVu activityVu = provideVu();
        return new Vu.ActivityVu[]{activityVu};
    }

    @Override
    public void bindVu(@Nullable Vu vu) {
        if (vu == null) {
            return;
        }
        //noinspection unchecked
        this.vu = ((V) vu);
    }

    public V getVu() {
        return vu;
    }

    public abstract void preMvpBinding(Bundle savedInstanceState);

    public abstract void afterMvpBinding(Bundle savedInstanceState);

    @Nullable
    public abstract Vu.ActivityVu provideVu();

    @Nullable
    public abstract Presenter providePresenter();
}

