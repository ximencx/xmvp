package com.xm.xmvpbase.vu;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.xm.xmvpbase.basemvp.BaseMvpActivity;
import com.xm.xmvpbase.presenter.Presenter;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public abstract class ActivityView<P extends Presenter> implements Vu.ActivityVu {

    private BaseMvpActivity activity;

    private P presenter;

    @Override
    public void bindPresenter(@Nullable Presenter presenter) {
        this.presenter = (P) presenter;
    }

    @Override
    public void bindActivity(@NonNull BaseMvpActivity activity) {
        this.activity = activity;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        if (activity != null) {
            LayoutInflater layoutInflater = activity.getLayoutInflater();
            int layoutRes = provideLayoutRes();
            View contentView = layoutInflater.inflate(layoutRes, null, false);
            activity.setContentView(contentView);
            bindBfView(this, contentView);
        }
    }

    @Override
    public void bindBfView(Object object, View view) {

    }

    @Override
    public void unBindBfView(Object object) {

    }

    public <T extends View> T findViewById(@IdRes int res) {
        return getActivity().findViewById(res);
    }

    @Override
    public void releaseView() {
        presenter = null;
        activity = null;
    }

    public BaseMvpActivity getActivity() {
        return activity;
    }

    public Context getContext() {
        return activity;
    }

    public P getPresenter() {
        return this.presenter;
    }

    /**
     * 提供View相关的布局资源ID
     *
     * @return 布局资源ID
     */
    @LayoutRes
    protected abstract int provideLayoutRes();
}
