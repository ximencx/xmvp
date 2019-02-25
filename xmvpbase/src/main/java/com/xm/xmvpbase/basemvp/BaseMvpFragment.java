package com.xm.xmvpbase.basemvp;

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
public abstract class BaseMvpFragment<V extends Vu.FragmentVu, P extends Presenter> extends Fragment implements Presenter {

    private V vu;

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

    private V getFragmentVu() {
        V view = null;
        if (view == null) {
            view = provideVu();
        }
        return view;
    }

    private P getPresenter() {
        P presenter = null;
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

    public BaseMvpFragment getFragment() {
        return this;
    }

    public BaseMvpActivity getHostActivity() {
        return (BaseMvpActivity) getActivity();
    }

    @Nullable
    public abstract V provideVu();

    @Nullable
    public abstract P providePresenter();

    public abstract void preMvpBinding(Bundle savedInstanceState);

    public abstract void afterMvpBinding(Bundle savedInstanceState);
}

