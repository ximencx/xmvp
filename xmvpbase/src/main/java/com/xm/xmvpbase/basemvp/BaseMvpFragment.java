package com.xm.xmvpbase.basemvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xm.xmvpbase.presenter.Presenter;
import com.xm.xmvpbase.vu.Vu;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public abstract class BaseMvpFragment<V extends Vu.FragmentVu> extends Fragment implements Presenter {

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

    public Fragment getFragment() {
        return this;
    }

    public Activity getHostActivity() {
        return this.getActivity();
    }

    @Nullable
    public abstract Vu.FragmentVu provideVu();

    @Nullable
    public abstract Presenter providePresenter();

    public abstract void preMvpBinding(Bundle savedInstanceState);

    public abstract void afterMvpBinding(Bundle savedInstanceState);
}

