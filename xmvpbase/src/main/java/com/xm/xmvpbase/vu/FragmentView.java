package com.xm.xmvpbase.vu;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xm.xmvpbase.basemvp.BaseMvpActivity;
import com.xm.xmvpbase.basemvp.BaseMvpFragment;
import com.xm.xmvpbase.presenter.Presenter;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public abstract class FragmentView<P extends Presenter> implements Vu.FragmentVu {

    private Fragment fragment;

    private P presenter;

    @Override
    public void bindPresenter(@Nullable Presenter presenter) {
        this.presenter = (P) presenter;
    }

    @Override
    public void bindFragment(@NonNull Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(provideLayoutRes(), container, false);
        bindBfView(this, contentView);
        return contentView;
    }

    @Override
    public void releaseView() {
        unBindBfView(this);
    }

    @Override
    public void bindBfView(Object object, View view) {

    }

    @Override
    public void unBindBfView(Object object) {

    }

    /**
     * 提供View相关的布局资源ID
     *
     * @return 布局资源ID
     */
    @LayoutRes
    protected abstract int provideLayoutRes();

    public BaseMvpFragment getFragment() {
        return (BaseMvpFragment) fragment;
    }

    public BaseMvpActivity getActivity() {
        if (fragment != null) {
            return (BaseMvpActivity) fragment.getActivity();
        }
        return null;
    }

    public P getPresenter() {
        return presenter;
    }

    public Context getContext() {
        return getActivity();
    }
}
