package com.xm.xmvp.di.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xm.xmvp.presenter.Presenter;
import com.xm.xmvp.vu.Vu;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:支持mvp+dagger2
 */
public abstract class SensibleFragment<V extends Vu.FragmentVu> extends SmartFragment implements Presenter {

    private V vu = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        preMvpBinding(savedInstanceState);

        Presenter presenter = getPresenter();

        Vu.FragmentVu view = getFragmentVu();

        if (presenter != null) {
            presenter.bindVu(view);
        }

        if (view != null) {
            view.bindPresenter(presenter);
            view.bindFragment(this);
            View targetView = view.initView(inflater, container, savedInstanceState);
            afterMvpBinding(savedInstanceState);
            return targetView;
        }
        return null;
    }

    private Vu.FragmentVu getFragmentVu() {
        Vu.FragmentVu view = null;
        if (view == null) {
            view = provideVu();
        }
        return view;
    }

    private Presenter getPresenter() {
        Presenter presenter = null;
        if (presenter == null) {
            presenter = providePresenter();
        }
        return presenter;
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

    @Nullable
    public abstract Vu.FragmentVu provideVu();

    @Nullable
    public abstract Presenter providePresenter();

    public abstract void preMvpBinding(Bundle savedInstanceState);

    public abstract void afterMvpBinding(Bundle savedInstanceState);
}

