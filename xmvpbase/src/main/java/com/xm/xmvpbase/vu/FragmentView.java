package com.xm.xmvpbase.vu;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xm.xmvpbase.basemvp.BaseMvpActivity;
import com.xm.xmvpbase.basemvp.BaseMvpFragment;
import com.xm.xmvpbase.presenter.Presenter;

/**
 *
 * @param <P>
 */
public abstract class FragmentView<P extends Presenter> implements Vu.FragmentVu {

    private Fragment fragment;

    private P presenter;

    private View rootView;

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
        rootView = inflater.inflate(provideLayoutRes(), container, false);
        return rootView;
    }

    @Override
    public void releaseView() {
        rootView = null;
        presenter = null;
        fragment = null;
    }

    @Override
    public void bindBfView(Object object, View view) {

    }

    @Override
    public void unBindBfView(Object object) {

    }

    public <T extends View> T findViewById(@IdRes int res) {
        return rootView.findViewById(res);
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
